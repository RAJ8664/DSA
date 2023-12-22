package GRAPH;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n + 1];
        Arrays.fill(vis,0);
        ArrayList<Integer> ans = new ArrayList<>();

        dfs(0,vis,ans,adj);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
    }
    public static void dfs(int current,int vis[],ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        vis[current] = 1;
        ans.add(current);
        for(int ele : adj.get(current)){
            if(vis[ele] == 0){
                dfs(ele,vis,ans,adj);
            }
        }
    }
}
