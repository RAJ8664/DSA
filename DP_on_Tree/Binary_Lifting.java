package DP_on_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Binary_Lifting {
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
        for(int current[] : dp) Arrays.fill(current, 0);
        dfs(1, 0, adj, dp);
        for(int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;

            while (k != 0) {
                if (k % 2 == 1) {
                    u = dp[u][cnt];

                }
                cnt++;
                k = k >> 1;
            }
            if (u == 0) System.out.println(-1);
            else System.out.println(u);
        }
    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , int dp[][]) {
        dp[u][0] = par;
        for(int i = 1; i <= 17; i++) {
            dp[u][i] = dp[dp[u][i - 1]][i - 1];
        }

        for(int v : adj.get(u)) {
            if(v != par) dfs(v, u, adj, dp);
        }
    }
}
