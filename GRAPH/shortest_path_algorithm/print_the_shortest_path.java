package GRAPH.shortest_path_algorithm;

import java.util.*;

public class print_the_shortest_path {
    static class Pair {
        int distance;
        int node;
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }

        ArrayList<Integer> res = new ArrayList<>();
        res = Dijkstra(n, adj);
        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }


    //print the path;
    public static ArrayList<Integer> Dijkstra(int n , ArrayList<ArrayList<Pair>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int dist[] = new int[200000 + 10];
        Arrays.fill(dist, (int)(9e9));
        int parent[] = new int[200000 + 10];
        for(int i = 1; i <= n; i++) parent[i] = i;

        //source node = 1;
        pq.offer(new Pair(0, 1));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            int cn = pq.peek().node;
            int cd = pq.peek().distance;
            pq.poll();
            for(int i = 0; i < adj.get(cn).size(); i++) {
                int nn = adj.get(cn).get(i).node;
                int nd = adj.get(cn).get(i).distance;
                if(dist[nn] > nd + cd) {
                    dist[nn] = nd + cd;
                    pq.offer(new Pair(dist[nn] , nn));
                    parent[nn] = cn;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(parent[n] == n) {
            res.add(-1);
            return res;
        }
        int node = n;
        while(parent[node] != node) {
            res.add(node);
            node = parent[node];
        }

        res.add(1);
        Collections.reverse(res);
        return res;
    }
}
