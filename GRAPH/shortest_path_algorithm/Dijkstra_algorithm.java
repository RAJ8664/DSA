package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_algorithm {
    static class Pair {
        int distance;
        int node;
        public Pair (int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int src = 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int distance = sc.nextInt();
            adj.get(u).add(new Pair(distance,v));
            adj.get(v).add(new Pair(distance,u));
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)(1e9));
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        pq.offer(new Pair(0,src));
        while(!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++) {
                int nn = adj.get(node).get(i).node;
                int ndis = adj.get(node).get(i).distance;
                if(dis + ndis < dist[nn]) {
                    dist[nn] = dis + ndis;
                    pq.offer(new Pair(dist[nn], nn));
                }
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
