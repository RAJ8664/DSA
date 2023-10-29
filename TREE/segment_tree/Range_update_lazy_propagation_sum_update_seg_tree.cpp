/*Author : RAJ ROY*/

#include <bits/stdc++.h>
using namespace std;

class Seg_Tree{
public:
	vector<unsigned long long> seg, lazy;
public:
	Seg_Tree(int n){
		seg.resize(4 * n + 5);
		lazy.resize(4 * n + 5);
	}
public:
	unsigned long long query(int arr[],int ind, int low, int high ,int l , int r){
		//update if any updates are remaining;
		if(lazy[ind] != 0){
			seg[ind] += (high - low + 1) * lazy[ind];
			//propagate down if the is children;
			if(low != high){
				lazy[2 * ind + 1] += lazy[ind];
				lazy[2 * ind + 2] += lazy[ind]; 
			} 
			lazy[ind] = 0;

		}

		//complete overlap;
		if(low >= l && high <= r) return seg[ind];

		//no overlap;
		if(low > r || high < l) return 0;

		int mid = low + (high - low) / 2;
		unsigned long long left = query(arr, 2 * ind + 1, low, mid, l , r);
		unsigned long long right =  query(arr, 2 * ind + 2, mid + 1, high , l , r);
		return (unsigned long long)(left + right);
	}
public:
	void Range_Update(int arr[],int ind, int low, int high, int l, int r,unsigned long long val){
		//check if previous lazy update is remaining;
		if(lazy[ind] != 0){
			seg[ind] += (high - low + 1) * lazy[ind];
			//propagate down if the is children;
			if(low != high){
				lazy[2 * ind + 1] += lazy[ind];
				lazy[2 * ind + 2] += lazy[ind]; 
			} 
			lazy[ind] = 0;

		}

		//no overlap case;
		if(low > r || high < l){
			return;
		}

		//complete overlap case;
		if(low >= l && high <= r){
			seg[ind] += (high - low + 1) * val; 

			//propogate downward to lazy if there is some children;
			if(low != high){
				lazy[2 * ind + 1] += val;
				lazy[2 * ind + 2] += val;
			}
			return;
		}

		//partial overlap case;

		int mid = low + (high - low) / 2;
		Range_Update(arr, 2 * ind + 1, low, mid,l, r, val);
		Range_Update(arr, 2 * ind + 2, mid + 1, high , l , r, val);
		seg[ind] = (unsigned long long)(seg[2 * ind + 1] + seg[2 * ind + 2]);

	}
public:
	void build(int arr[],int ind,int low, int high){
		if(low == high) {
			seg[ind] = arr[low];
			return;
		}

		int mid = low + (high - low) / 2;
		build(arr, 2 * ind + 1, low, mid);
		build(arr, 2 * ind + 2, mid + 1, high);
		seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
	}

};


int main(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


	int n, q;
	cin >> n >> q;
	int arr[n];
	for(int i = 0; i < n; i++){
		int x;
		cin >> x;
		arr[i] = x;
	} 

	Seg_Tree s1(n);
	s1.build(arr, 0 , 0 , n - 1);
	for(int i = 0; i < q; i++){
		int type;
		cin >> type;
		if(type == 1){
			// update type;
			int l , r , val;
			cin >> l >> r >> val;
			--l;
			--r;
			s1.Range_Update(arr, 0 , 0 , n - 1, l , r,val);

		}
		else {
			int l , r;
			cin >>  l >> r;
			--l;
			--r;
			cout << s1.query(arr, 0 , 0 , n - 1, l , r) << endl;
		}
	}

}