/*Author : Raj Roy*/

#include<bits/stdc++.h>
using namespace std;


void bfs(int current,vector<int>& ans,int vis[],vector<int> adj[],queue<int> q){
	vis[current] = 1;
	q.push(0);
	while(!q.empty()){
		int current = q.front();
		q.pop();
		ans.push_back(current);
		for(auto it: adj[current]){
			if(!vis[it]){
				vis[it] = 1;
				q.push(it);
			}
		}
	}
}
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
	vector<int> ans;
	bfs(0,ans,vis,adj,q);
	for(int i = 0; i < ans.size(); i++){
		cout << ans[i] << " ";
	}
	cout << endl;
}