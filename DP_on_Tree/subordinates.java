package DP_on_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class subordinates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n - 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());

        for(int i = 0; i <= n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = i + 2;
            adj.get(u).add(v);
        }

        int dp[] = new int[n + 1];
        int res = solve(1,adj, dp);
        for(int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }


    public static int solve(int current, ArrayList<ArrayList<Integer>> adj , int dp[]) {
        if (adj.get(current).size() == 0) return 1;
        else {
            for (int child : adj.get(current)) {
                dp[current] += solve(child,adj, dp);
            }
        }
        return dp[current] + 1;

    }
}
