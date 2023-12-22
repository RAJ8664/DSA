package GRAPH.Topological_sort;

import java.util.*;

public class topological_sort {
    public static void main(String[] args) {
        //directed acyclic graph;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);

        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(vis[i] == 0) {
                dfs(i,adj,vis,st);
            }
        }

        while(st.size() > 0) {
            ans.add(st.pop());
        }

        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void dfs(int u, ArrayList<ArrayList<Integer>> adj, int vis[], Stack<Integer> st) {
        vis[u] = 1;
        for(int child : adj.get(u)) {
            if(vis[child] == 0) {
                dfs(child, adj,vis,st);
            }
        }
        st.push(u);
    }


    //kahn's algorithm (find topo sort using bfs);
    public static ArrayList<Integer> topo_bfs(int n ,ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[n + 1];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) {
                indegree[ele]++;
            }
        }
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
        return ans;
    }
}
