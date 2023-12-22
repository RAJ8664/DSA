package GRAPH.Topological_sort;

import java.util.*;

public class find_eventual_safe_states {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Read the problem statement first;
        //Do the input part;
        //First convert the reverse adjacency list to solve this problem;
        //that is change the edges between the given graph matrix;
        //depending upon the input that is given you need the reverse the edges and make
        //the adjacency list;




    }

    public static ArrayList<Integer> solve(int graph[][]) {
        int n = graph.length;
        int m = graph[0].length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; i++) {
                adj.get(graph[i][j]).add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int indegree[] = new int[n + 1];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) indegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int current = q.peek();
            q.poll();
            ans.add(current);
            for(int child : adj.get(current)) {
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
