package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Cheapest_filghts_within_k_stops {
    //Read the problem statement on geeksforgeeks;
    //we will give priority to stops instead of distance;
    static class Pair{
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    static class Tuple {
        int stop;
        int node;
        int distance;
        public Tuple(int stop,int node,int distance) {
            this.stop = stop;
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int edges[][] = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : edges) {
            int u = current[0];
            int v = current[1];
            int dist = current[2];
            adj.get(u).add(new Pair(v,dist));
        }


        int res = solve(adj,s,d,k);
        System.out.println(res);
    }


    public static int solve(ArrayList<ArrayList<Pair>> adj ,int src,int dst, int k) {
        int n = adj.size();
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)(1e9));
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.stop - y.stop);
        pq.offer(new Tuple(0,src,0));
        while(!pq.isEmpty()) {
            int cs = pq.peek().stop;
            int cn = pq.peek().node;
            int cd = pq.peek().distance;
            pq.poll();
            for(int i = 0; i < adj.get(cn).size(); i++) {
                int current_node = adj.get(cn).get(i).node;
                int current_distance = adj.get(cn).get(i).distance;
                if(dist[current_node] > cd + current_distance && cs <= k) {
                    dist[current_node] = cd + current_distance;
                    pq.offer(new Tuple(cs + 1, current_node, dist[current_node]));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
