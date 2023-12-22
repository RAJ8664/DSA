package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Network_delay_time {
    //Read the problem statement on leetcode;
    static class Pair {
        int distance, node;
        public Pair (int distance , int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : times) {
            int u = current[0];
            int v = current[1];
            int dist = current[2];
            adj.get(u).add(new Pair(dist,v));
        }
        int res = solve(adj,k,n);
        return res;
    }

    public static int solve(ArrayList<ArrayList<Pair>> adj , int src, int n) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)(1e9));
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(0,src));
        dist[src] = 0;
        while(!pq.isEmpty()) {
            int curr_node = pq.peek().node;
            int curr_dist = pq.peek().distance;
            pq.poll();
            for(int i = 0; i < adj.get(curr_node).size(); i++) {
                int child_node = adj.get(curr_node).get(i).node;
                int child_dist = adj.get(curr_node).get(i).distance;
                if(dist[child_node] > child_dist + curr_dist) {
                    dist[child_node] = child_dist + curr_dist;
                    pq.offer(new Pair(dist[child_node] , child_node));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        boolean found = false;
        for(int i = 1; i <= n; i++) {
            //System.out.print(dist[i] + " ");
            if(dist[i] == (int)(1e9)) {
                found = true;
                break;
            }
            else {
                max = Math.max(max, dist[i]);
            }
        }
        if(found) return -1;
        return max;
    }
}
