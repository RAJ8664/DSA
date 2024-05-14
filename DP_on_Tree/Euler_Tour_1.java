package DP_on_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Euler_Tour_1 {
    public static void main(String[] args) {
        //still left to complete;
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

        //flat stores the path of dfs;
        ArrayList<Integer> flat = new ArrayList<>();

        //index array stores the first occurence of each element;
        int index[] = new int[n + 1];
        Arrays.fill(index, -1);

        int depth[] = new int[n + 1];
        
        dfs(1, -1, adj , flat,depth);
        
        for(int i = 0; i < flat.size(); i++) {
            if(index[flat.get(i)] == -1) {
                index[flat.get(i)] = i;
            }
        }
        
        int seg[] = new int[4 * flat.size() + 10];
        build(flat, seg, 0, 0, flat.size() - 1, depth);
        
        //find the lca = (5, 4);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int l = index[a];
        int r = index[b];
        System.out.println(query(flat, seg,0,0,flat.size() - 1, l , r));
    }

    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> flat,int depth[]) {
        flat.add(u);
        for(int v : adj.get(u)) {
            if(v != par) {
                depth[v] = 1 + depth[u];
                dfs(v, u, adj, flat,depth);
                flat.add(u);
            }
        }
    }

    //segment tree part;
    public static void build(ArrayList<Integer> arr, int seg[] , int ind, int low , int high,int depth[]) {
        if(low == high) {
            seg[low] = arr.get(low);
            return;
        }

        int mid = low + (high - low) / 2;
        build(arr, seg, 2 * ind + 1, low, mid, depth);
        build(arr, seg, 2 * ind + 2, mid + 1, high , depth);
        if(depth[seg[2 * ind + 1]] > depth[seg[2 * ind + 2]]) {
            seg[ind] = seg[2 * ind + 2];
        }
        else seg[ind] = seg[2 * ind + 1];
    }

    public static int query(ArrayList<Integer> arr, int seg[] , int ind, int low , int high , int l , int r) {
        if(low >= l && high <= r) return seg[ind];
        if(low > r || high < l) return Integer.MAX_VALUE;
        int mid = low + (high - low) / 2;
        int left = query(arr, seg, 2 * ind + 1, low, mid ,l , r);
        int right = query(arr, seg, 2 * ind + 2 , mid + 1, high , l ,r);
        return Math.min(left, right);
    }
}
