package DP_on_Tree;
import java.util.Scanner;
import java.util.ArrayList;
public class Tree_Distances_1 {
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

        int in[] = new int[n + 1];
        int out[] = new int[n + 1];
        dfs1(1, -1, adj, in);
        dfs2(1, -1, adj, out, in);
        for(int i = 1; i <= n; i++) {
            int res = Math.max(in[i] , out[i]);
            System.out.print(res + " ");
        }
    }

    public static void dfs1(int u , int par, ArrayList<ArrayList<Integer>> adj ,int in[]) {
        if(adj.get(u).size() == 1 && u != 1) {
            in[u] = 0;
            return;
        }

        for(int v : adj.get(u)) {
            if(v != par) dfs1(v, u , adj ,in);
        }

        for(int v : adj.get(u)) {
            if(v != par) {
                in[u] = Math.max(in[u], 1 + in[v]);
            }
        }
    }

    public static void dfs2(int u , int par, ArrayList<ArrayList<Integer>> adj , int out[],int in[]) {
        int mx1 = -1;
        int mx2 = -1;
        for(int v : adj.get(u)) {
            if(v != par) {
                if(mx1 <= in[v]) {
                    mx2 = mx1;
                    mx1 = in[v];


                }
                else if(mx2 < in[v]) {
                    mx2 = in[v];
                }
            }
        }

        for(int v : adj.get(u)) {
            if(v != par) {
                int longest = mx1;
                if(mx1 == in[v]) longest = mx2;
                out[v] = 1 + Math.max(out[u] , 1 + longest);
                dfs2(v, u, adj , out, in);
            }
        }
    }
}
