package GRAPH;

import java.util.*;

public class bipartite_graph {
    public static void main(String[] args) {
        /*
         //A graph having no cycle is always a bpt graph;
         //A graph having a cycle with even length is also a bpt graph
         //A graph having a cycle with odd length then it is not a bpt graph;
        */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int color[] = new int[n + 1];
        Arrays.fill(color, -1);
        boolean ans = true;
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                if(check_bfs(i,adj,color) == false) ans = false;
            }
        }
        if(ans == true) System.out.println("YES");
        else System.out.println("NO");
    }


    //bfs approach;
    public static boolean check_bfs(int u, ArrayList<ArrayList<Integer>> adj, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        color[u] = 0;
        while(!q.isEmpty()) {
            int par = q.peek();
            q.poll();
            for(int child : adj.get(par)) {
                if(color[child] == -1) {
                    color[child] = 1 - color[par];
                    q.add(child);
                }
                else if(color[child] == color[par]) return false;
            }
        }
        return true;
    }


    //dfs approach;
    public static boolean dfs(int u , ArrayList<ArrayList<Integer>> adj ,int color[],int col) {
        color[u] = col;
        boolean ans = true;
        for(int child : adj.get(u)) {
            if(color[child] == -1) {
                ans &=  dfs(child, adj,color, 1 - col);

            }
            else if(color[child] == color[u]) return false;
        }
        return ans;
    }
}
