package DP_on_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Subtree_Queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n + 1];
        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //dfs to fill the flat array (Euler tour 2);
        ArrayList<Integer> flat = new ArrayList<>();
        dfs(1, -1, adj, flat);

        //store the first and last index of elements in the flat;
        int first[] = new int[n + 1];
        int last[] = new int[n + 1];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for(int i = 0; i < flat.size(); i++) {
            int current = flat.get(i);
            if(first[current] == -1) first[current] = i;
            else last[current] = i;
        }

        //res array will be storing the value of each element present in array arr;
        int res[] = new int[flat.size()];
        for(int i = 0; i < flat.size(); i++) {
            res[i] = arr[flat.get(i)];
        }

        System.out.println(Arrays.toString(res));

        //segment tree;
        long seg[] = new long[4 * res.length + 10];
        build(res, seg,0, 0, res.length - 1);


        //queries;
        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if(type == 1) {
                int indx = sc.nextInt();
                int val = sc.nextInt();
                update(res, seg,0,0,res.length - 1,first[indx],val);
                update(res, seg,0,0,res.length - 1, last[indx], val);
            }
            else {
                int node = sc.nextInt();
                int l = first[node];
                int r = last[node];
                System.out.println(query(res, seg,0,0,res.length - 1, l , r) / 2);
            }
        }
    }

    //dfs to fill the flat array;
    public static void dfs(int u , int par, ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> flat) {
        flat.add(u);
        for(int v : adj.get(u)) {
            if(v != par) {
                dfs(v, u, adj, flat);
            }
        }
        flat.add(u);
    }

    //sum segment tree on res array;
    public static void update(int arr[],long seg[],int ind, int low, int high , int index,int val){
        if(low == high){
            seg[ind] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        if(index <= mid) update(arr, seg, 2 * ind + 1, low, mid,index, val);
        else update(arr, seg,2 * ind + 2, mid + 1, high , index, val);
        seg[ind] = seg[2 * ind + 1] +  seg[2 * ind + 2];
    }

    public static long query(int arr[] , long seg[], int ind, int low , int high, int l , int r) {
        if(low >= l && high <= r) return seg[ind];
        if(low > r || high < l) return 0;
        int mid = low + (high - low) / 2;
        long left = query(arr, seg, 2 * ind + 1, low, mid, l , r);
        long right = query(arr, seg, 2 * ind + 2, mid + 1 , high , l , r);
        return (long)(left + right);
    }

    public static void build(int arr[] , long seg[] , int ind,  int low , int high) {
        if(low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(arr, seg, 2 * ind + 1, low , mid);
        build(arr, seg, 2 * ind + 2, mid + 1, high);
        seg[ind] = (long)(seg[2 * ind + 1]  + seg[2 * ind + 2]);
    }
}
