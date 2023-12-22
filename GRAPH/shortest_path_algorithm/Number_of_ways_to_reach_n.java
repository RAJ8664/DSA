package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number_of_ways_to_reach_n {
    static class Pair {
        long distance;
        int node;
        public Pair(long distance , int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;

    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : roads) {
            int u = current[0];
            int v = current[1];
            long dist = (long)current[2];
            adj.get(u).add(new Pair(dist,v));
            adj.get(v).add(new Pair(dist,u));
        }
        int res = solve(adj,n);
        return res;
    }

    public static int solve(ArrayList<ArrayList<Pair>> adj,int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (int)x.distance - (int)y.distance);
        long dist[] = new long[n + 1];
        Arrays.fill(dist, (long)(1e18));
        int ways[] = new int[n + 1];
        Arrays.fill(ways,0);
        ways[0] = 1;
        dist[0] = 0;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()) {
            int curr_node = pq.peek().node;
            long curr_dist = (long)pq.peek().distance;
            pq.poll();
            for(int i = 0; i < adj.get(curr_node).size(); i++) {
                int child_node = adj.get(curr_node).get(i).node;
                long child_dist = (long)adj.get(curr_node).get(i).distance;
                if(dist[child_node] > (long)(curr_dist + child_dist)) {
                    dist[child_node] = (long)(curr_dist + child_dist);
                    ways[child_node] = ways[curr_node];
                    pq.offer(new Pair(dist[child_node] , child_node));
                }
                else if(dist[child_node] == (long)(curr_dist + child_dist)) {
                    ways[child_node] = (ways[child_node] + ways[curr_node]) % ((int)(1e9 + 7));
                }
            }
        }
        return ways[n - 1];
    }
}
