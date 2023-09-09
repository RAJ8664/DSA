/*Author : Raj Roy*/

#include<bits/stdc++.h>
using namespace std;

int main(){
	//Total Number Of Degree in a graph = 2 * Number of Edges;
	
	//Representation of undirected graph in c++
	//storing the graph using adjacency matrix;
	
	int n , m;   // Here the n = number of node and m = number of edges;
	cin >> n >> m;
	
	//space complexity = O(n * n);
	int graph[n + 1][n + 1];
	for(int i = 0; i < m; i++){
		int u , v;
		cin >> u >> v;
		graph[u][v] = 1;
		graph[v][u] = 1;
	}
	
	//check if there is an edge between a and b;
	int x , y;
	cin >> x >>y;
	if(graph[x][y] == 1){
		cout << "YES" << endl;
	}
	else{
		cout << "NO" << endl;
	}
	
	//representation using adjacency list;
	//space complexity = O(2 * number of edges); 
	int n1 , m1;
	cin >> n1 >> m1;
		
	vector<int> graph[n + 1];
	for(int i = 0; i < m1; i++){
		int u , v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
}