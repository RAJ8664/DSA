package GRAPH.Topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Course_Schedule_2 {
    //read the problem statement on leetcode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input and ouput part;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : prerequisites) {
            int u = current[0];
            int v = current[1];
            adj.get(v).add(u);

        }

        int indegree[] = new int[numCourses + 1];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) indegree[ele]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solve(numCourses,adj,indegree);
        int k = 0;
        int arr[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            arr[k++] = ans.get(i);
        }
        return arr;
    }

    public static ArrayList<Integer> solve(int n, ArrayList<ArrayList<Integer>> adj, int indegree[]) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int current = q.peek();
            q.poll();
            ans.add(current);
            for(int child : adj.get(current)) {
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        if(ans.size() == n) return ans;
        ans.clear();
        return ans;
    }
}
