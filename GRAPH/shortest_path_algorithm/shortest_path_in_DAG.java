package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class shortest_path_in_DAG {
    static class Pair {
        int first;
        int second;
        public Pair(int first , int  second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int source = sc.nextInt();
        int edges[][] = new int[m + 1][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                edges[i][j] = sc.nextInt();
            }
        }

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<Pair>());

        for(int current[] : edges) {
            int u = current[0];
            int v = current[1];
            int w = current[2];
            adj.get(u).add(new Pair(v,w));
        }

        int vis[] = new int[n + 1];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                dfs(i,adj,st,vis);
            }
        }

        int dist[] = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[source] = 0;
        while(st.size() > 0) {
            int current = st.peek();
            st.pop();
            for(int i = 0; i < adj.get(current).size(); i++) {
                int v = adj.get(current).get(i).first;
                int wt = adj.get(current).get(i).second;
                if(dist[current] + wt < dist[v]) {
                    dist[v] = dist[current] + wt;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dist[i] == (int)(1e9)) dist[i] = -1;
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void dfs(int u , ArrayList<ArrayList<Pair>> adj ,Stack<Integer> st, int vis[]) {
        vis[u] = 1;
        for(int i = 0; i < adj.get(u).size(); i++) {
            int current = adj.get(u).get(i).first;
            if(vis[current] == 0) {
                dfs(current,adj,st,vis);
            }
        }
        st.push(u);
    }
}
