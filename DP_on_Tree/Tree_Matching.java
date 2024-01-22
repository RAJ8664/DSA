package DP_on_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree_Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int dp[][] = new int[n + 1][2];
        dfs(1, -1, adj, dp);
        int res = Math.max(dp[1][0] , dp[1][1]);
        System.out.println(res);


    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj,int dp[][]) {
        if(adj.get(u).size() == 1 && u != 1) {
            dp[u][0] = dp[u][1] = 0;
            return;
        }

        for(int v : adj.get(u)) {
            if(v != par) dfs(v, u, adj, dp);
        }

        for(int v : adj.get(u)) {
            if(v != par) {
                dp[u][0] += Math.max(dp[v][0] , dp[v][1]);
            }
        }

        for(int v : adj.get(u)) {
            if(v != par) {
                dp[u][1] = Math.max(dp[u][1] , 1 + dp[v][0] + dp[u][0] - Math.max(dp[v][1] , dp[v][0]));
            }
        }
    }
}
