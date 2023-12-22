package TREE;

import java.util.ArrayList;
import java.util.Scanner;

public class Height_Depth_of_tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n - 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int height[] = new int[n + 1];
        int depth[] = new int[n + 1];
        dfs(1, -1, depth,height,adj);

        for(int i = 1; i <= n; i++) {
            System.out.println(height[i] + " " + depth[i]);
        }


    }

    public static void dfs(int u, int par,int depth[],int height[],ArrayList<ArrayList<Integer>> adj) {
        for(int child : adj.get(u)) {
            if(child == par) continue;
            depth[child] = depth[u] + 1;
            dfs(child, u,depth,height,adj);
            height[u] = Math.max(height[u],height[child] + 1);
        }
    }
}
