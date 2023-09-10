/*Author : Raj Roy*/

#include<bits/stdc++.h>
using namespace std;

int main(){
	int n , m;
	//n = number of nodes;
	// m = number of vertices;
	cin >> n >> m;
	vector<int> adj[n + 1];
	for(int i = 0; i < m; i++){
		int u , v;
		cin >> u >>  v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	
	//bfs;
	//zero is the starting node;
	int vis[n + 1] = {0};
	queue<int> q;
	vis[0] = 1;
	q.push(0);
	vector<int> ans;
	while(!q.empty()){
		int current = q.front();
		q.pop();
		ans.push_back(current);
		for(auto it : adj[current]){
			if(!vis[it]){
				q.push(it);
				vis[it] = 1;
			}
		}
	}
	for(int i = 0; i < ans.size(); i++){
		cout << ans[i] << " ";
	}
	cout << endl;
}