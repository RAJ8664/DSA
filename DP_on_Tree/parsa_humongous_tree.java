package DP_on_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class parsa_humongous_tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i <= n + 2; i++) adj.add(new ArrayList<>());
            int l[] = new int[n + 1];
            int r[] = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                int li = sc.nextInt();
                int ri = sc.nextInt();
                l[i] = li;
                r[i] = ri;
            }

            for(int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            long dp[][] = new long[n + 1][2];
            dfs(1, -1, adj ,dp , l ,r);
            long res = Math.max(dp[1][0] , dp[1][1]);
            System.out.println(res);
        }
    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , long dp[][], int l[], int r[]) {
        //dp[u][0] = maximum ans possible, selecting l value for node u;
        //dp[u][1] = maximum ans possible, selecting r value for node u;

        for(int v : adj.get(u)) {
            if(v != par) dfs(v, u, adj, dp, l ,r);
        }

        for(int v : adj.get(u)) {
            if(v != par) {
                dp[u][0] += Math.max(Math.abs(l[u] - r[v]) + dp[v][1] , Math.abs(l[u] - l[v]) + dp[v][0]);
                dp[u][1] += Math.max(Math.abs(r[u] - r[v]) + dp[v][1] , Math.abs(r[u] - l[v]) + dp[v][0]);
            }
        }
    }
}
