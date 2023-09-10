/*Author : Raj Roy*/

#include<bits/stdc++.h>
using namespace std;


void dfs(int current,vector<int>& ans,vector<int> adj[] ,int vis[]){
	vis[current] = 1;
	ans.push_back(current);
	for(auto it: adj[current]){
		if(!vis[it]){
			dfs(it,ans,adj,vis);
		}
	}
}
int main(){
	int n , m;
	cin >> n >> m;
	
	vector<int> ans;
	vector<int> adj[n + 1];
	int vis[n + 1] = {0};
	for(int i = 0; i < m; i++){
		int v, u;
		cin >> v >> u;
		adj[v].push_back(u);
		adj[u].push_back(v);
	}
	
	dfs(0,ans,adj,vis);
	for(int i = 0; i < ans.size(); i++){
		cout << ans[i] << " ";
	}
	cout << endl;
}