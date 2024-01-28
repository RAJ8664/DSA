package DP_on_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Distance_Queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int depth[] = new int[n + 1];
        dfs(1, -1, adj, depth);

        int dp[][] = new int[n + 1][18];
        dfs1(1, 0, adj, dp);


        while(q-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int lca = lca(a, b, dp, depth);
            int res = (depth[a] + depth[b] - 2 * depth[lca]);
            System.out.println(res);
        }
    }


    //to fill the dp array, which stores all the parent of powers of two;
    public static void dfs1(int u , int par, ArrayList<ArrayList<Integer>> adj , int dp[][]) {
        dp[u][0] = par;
        for(int i = 1; i <= 17; i++) {
            dp[u][i] = dp[dp[u][i - 1]][i - 1];
        }

        for(int v : adj.get(u)) {
            if(v != par) dfs1(v, u, adj, dp);
        }
    }





    //to calculate the depth of each node;
    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , int depth[]) {
        for(int v : adj.get(u)) {
            if(v != par) {
                depth[v] = 1 + depth[u];
                dfs(v, u, adj, depth);
            }
        }
    }



    //to find the kth parent of node u;
    public static int kth_parent(int u ,int k , int dp[][]) {
        int count = 0;
        while(k != 0) {
            if(k % 2 == 1) {
                u = dp[u][count];
            }
            count++;
            k = k >> 1;
        }
        return u;
    }


    //to find the lca of two nodes;
    public static int lca(int a , int b , int dp[][] , int depth[]) {
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[b] - depth[a];
        b = kth_parent(b, diff, dp);
        if(a == b) return a;
        for(int i = 17; i >= 0; i--) {
            if(dp[a][i] != dp[b][i]) {
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        return dp[a][0];
    }
}
