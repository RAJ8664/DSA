package GRAPH.Topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class detect_cycle_in_directed_graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        int indegree[] = new int[n];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) {
                indegree[ele]++;
            }
        }
        System.out.println(iscycle(n,adj,indegree));


    }

    public static  boolean iscycle(int n , ArrayList<ArrayList<Integer>> adj,int indegree[]) {
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int current = q.peek();
            q.poll();
            visited++;
            for(int child : adj.get(current)) {
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        return visited != n;
    }
}
