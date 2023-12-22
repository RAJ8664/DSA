package GRAPH.spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Minimum_spanning_tree {
    //using prim's algorithm;
    //total number of spanning tree possible in given graph = ((edges) C (vertex - 1)) - (total number of cycles in the graph);

    static class Pair {
        int node, distance;
        public Pair(int node ,int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static class Tuple {
        int distance , node, parent;
        public Tuple(int distance ,int node, int parent) {
            this.distance = distance;
            this.node = node;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= edges.size() + 2; i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> current : edges) {
            int u = current.get(0);
            int v = current.get(1);
            int wt = current.get(2);
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        //res will be having the list of edges;
        ArrayList<Pair> res = new ArrayList<>();
        int ans = spanning(adj,res);
        return ans;
    }

    public static int spanning(ArrayList<ArrayList<Pair>> adj, ArrayList<Pair> res) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);
        int vis[] = new int[adj.size() + 1];
        Arrays.fill(vis,0);
        pq.offer(new Tuple(0,0,-1));
        int sum = 0;
        while(!pq.isEmpty()) {
            int cn = pq.peek().node;
            int cd = pq.peek().distance;
            int par = pq.peek().parent;
            pq.poll();
            if(vis[cn] == 1) continue;
            sum += cd;
            if(par != -1 ) res.add(new Pair(cn, par));
            vis[cn ] = 1;
            for(int i = 0; i < adj.get(cn).size(); i++) {
                int child_node = adj.get(cn).get(i).node;
                int child_dist = adj.get(cn).get(i).distance;
                if(vis[child_node] == 0) {
                    pq.offer(new Tuple(child_dist, child_node, cn));
                }
            }
        }
        return sum;
    }
}
