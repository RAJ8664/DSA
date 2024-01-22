package DP_on_Tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Binary_Lifting_LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = i + 2;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int dp[][] = new int[n + 1][18];
        dfs(1, 0, adj, dp);

        int depth[] = new int[n + 1];
        depth(1, -1, adj, depth);

        for(int i = 0; i < q; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            System.out.println(lca(node1, node2, depth, dp));
        }
    }


    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , int dp[][]) {
        dp[u][0] = par;
        for(int i = 1; i <= 17; i++) {
            dp[u][i] = dp[dp[u][i - 1]][i - 1];
        }
        for(int v : adj.get(u)) {
            if(v != par) dfs(v, u, adj ,dp);
        }
    }


    public static void depth(int u , int par, ArrayList<ArrayList<Integer>> adj , int depth[]) {
        for(int v : adj.get(u)) {
            if(v != par) {
                depth[v] = 1 + depth[u];
                depth(v, u, adj ,depth);
            }
        }
    }

    public static int find_kth_parent(int u , int k , int dp[][]) {
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

    public static int lca(int node1 , int node2,int depth[] , int dp[][]) {
        //another way , commented code is also correct;

        if(depth[node1] > depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        int diff = depth[node2] - depth[node1];
        node2 = find_kth_parent(node2 ,  diff, dp);

        if(node1 == node2) return node1;
        for(int i = 17; i >= 0; i--) {
            if(dp[node1][i] != dp[node2][i]) {
                node1 = dp[node1][i];
                node2 = dp[node2][i];
            }
        }
        return dp[node1][0];

//        if(depth[node1] > depth[node2]) {
//            int diff = depth[node1] - depth[node2];
//            node1 = find_kth_parent(node1, diff, dp);
//
//            if(node1 == node2) {
//                return node1;
//            }
//
//            for(int k = 17; k >= 0; k--) {
//                if(dp[node1][k] != dp[node2][k]) {
//                    node1 = dp[node1][k];
//                    node2 = dp[node2][k];
//                }
//            }
//            return dp[node1][0];
//
//
//        }
//        else {
//            int diff = depth[node2] - depth[node1];
//            node2 = find_kth_parent(node2, diff , dp);
//
//            if(node1 == node2) {
//                return node1;
//            }
//
//            for(int k = 17; k >= 0; k--) {
//                if(dp[node1][k] != dp[node2][k]) {
//                    node1 = dp[node1][k];
//                    node2 = dp[node2][k];
//                }
//            }
//            return dp[node1][0];
//        }
    }
}
