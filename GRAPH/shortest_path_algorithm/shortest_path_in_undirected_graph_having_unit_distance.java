package GRAPH.shortest_path_algorithm;

import java.util.*;

public class shortest_path_in_undirected_graph_having_unit_distance {
    static class Pair {
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int src = sc.nextInt();
        int edges[][] = new int[m][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        int dist[] = new int[n];
        dist = shortestPath(edges,n,m,src);
        System.out.println(Arrays.toString(dist));

    }

    public static int[] shortestPath(int[][] edges,int n,int m ,int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : edges) {
            int u = current[0];
            int v = current[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int dist[] = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));
        int vis[] = new int[n];
        vis[src] = 1;
        while(!q.isEmpty()) {
            int curr_node = q.peek().node;
            int curr_dist = q.peek().dist;
            q.poll();
            for(int child : adj.get(curr_node)) {
                if(vis[child] == 0) {
                    dist[child] = curr_dist + 1;
                    q.offer(new Pair(child, dist[child]));
                    vis[child] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(dist[i] == (int)(1e9)) dist[i] = -1;
        }
        return dist;
    }
}
