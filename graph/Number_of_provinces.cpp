/*Author : Raj Roy*/

#include<bits/stdc++.h>
using namespace std;

void dfs(int current,vector<int> adj[],int vis[]){
	vis[current] = 1;
	for(auto it : adj[current]){
		if(!vis[it]){
			dfs(it,adj,vis);
		}
	}
}

int main(){
	int n , m;
	cin >> n >> m;
	vector<int> adj[n + 1];
	int vis[n+1];
	for(int i = 0; i < m; i++){
		int u , v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	
	int count = 0;
	for(int i = 0; i < n; i++){
		if(!vis[i]){
			count++;
			dfs(i,adj,vis);
			
		}
	}
	cout << count << endl;
}