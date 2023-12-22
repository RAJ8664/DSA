package GRAPH.Topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Course_Schedule {
    //read the statement on leetcode;
    //there should not be any cycle in given directed graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //do the input part;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <n + 1; i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n + 1];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) indegree[ele]++;
        }

        if (solve(adj,indegree, n) == true) {
            System.out.println("YES");
        }
        else System.out.println("NO");

    }

    public static boolean solve(ArrayList<ArrayList<Integer>> adj , int indegree[],int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int current  = q.peek();
            q.poll();
            count++;
            for(int child : adj.get(current)) {
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        if(count == n) return true;
        return false;
    }
}
