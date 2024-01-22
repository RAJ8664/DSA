package DP_on_Tree;

import java.util.ArrayList;
import java.util.Scanner;
public class Kth_parent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int node = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int parent[] = new int[n + 1];
        dfs(1, -1, adj, parent);
        int ans = -1;
        while(k != 0) {
            ans = parent[node];
            node = parent[node];
            k--;
        }
        System.out.println(ans);
    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , int parent[]) {
        for(int v : adj.get(u)) {
            if(v != par) {
                parent[v] = u;
                dfs(v, u, adj, parent);
            }
        }
    }
}
