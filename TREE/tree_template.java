package TREE;

import java.util.ArrayList;
import java.util.Scanner;

public class tree_template {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int height[] = new int[n + 1];
        int depth[] = new int[n + 1];
        int subtree[] = new int[n + 1];
        height(1,-1,adj,height);
        depth(1,-1,adj,depth);
        subtree(1,-1,adj,subtree);
        for(int i = 1; i <= n; i++) {
            System.out.println(height[i]  + 1 + " " + depth[i] + " " + (subtree[i] - 1));
        }

    }

    public static void height(int u , int par, ArrayList<ArrayList<Integer>> adj ,int height[]) {
        for(int child : adj.get(u)) {
            if(child == par) continue;
            height(child, u, adj,height);
            height[u] = Math.max(height[u] , height[child] + 1);
        }
    }

    public static void depth(int u , int par, ArrayList<ArrayList<Integer>> adj, int depth[]) {
        for(int child : adj.get(u)) {
            if(child == par) continue;
            depth[child] = depth[u] + 1;
            depth(child, u, adj,depth);
        }
    }

    public static void subtree(int u , int par, ArrayList<ArrayList<Integer>> adj ,int subtree[]) {
        subtree[u] = 1;
        for(int child : adj.get(u)) {
            if(child == par) continue;
            subtree(child, u, adj,subtree);
            subtree[u] += subtree[child];
        }
    }
}
