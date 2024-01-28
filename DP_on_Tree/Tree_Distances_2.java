package DP_on_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree_Distances_2 {
    static class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

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

        int subtree[] = new int[n + 1];
        dfs(1, -1, adj, subtree);
        int sum = bfs(n , 1, adj);
        int res[] = new int[n + 1];
        res[1] = sum;
        dfs1(n, 1, -1, adj, res, subtree);
        for(int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }

    }
    public static void dfs1(int n , int u , int par, ArrayList<ArrayList<Integer>> adj , int res[],int subtree[]) {
        for(int v : adj.get(u)) {
            if(v != par) {
                res[v] = res[u] - subtree[v] + (n - subtree[v]);
                dfs1(n , v, u , adj, res, subtree);
            }
        }
    }

    public static int bfs(int n , int u , ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[n + 1];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(u, 0));
        vis[u] = 1;
        int sum = 0;
        while(!q.isEmpty()) {
            int cn = q.peek().node;
            int cd = q.peek().distance;
            sum += cd;
            q.poll();
            for(int i = 0; i < adj.get(cn).size(); i++) {
                int nn = adj.get(cn).get(i);
                int nd = cd + 1;
                if(vis[nn] == 0) {
                    q.offer(new Pair(nn , nd));
                    vis[nn] = 1;
                }
            }
        }
        return sum;
    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , int subtree[]) {
        if(adj.get(u).size() == 1 && u != 1) {
            subtree[u] = 1;
            return;
        }
        for(int v : adj.get(u)) {
            if(v != par) {
                dfs(v, u, adj, subtree);
            }
        }
        for(int v : adj.get(u)) {
            if(v != par) {
                subtree[u] += subtree[v];
            }
        }
        subtree[u]++;
    }
}
