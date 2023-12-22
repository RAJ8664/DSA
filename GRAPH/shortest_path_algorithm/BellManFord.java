package GRAPH.shortest_path_algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFord {
    public static void main(String[] args) {

    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist, (int)(1e8));
        dist[S] = 0;
        for(int i = 1; i <= V - 1; i++) {
            for(ArrayList<Integer> current : edges) {
                int u = current.get(0);
                int v = current.get(1);
                int wt = current.get(2);
                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //question stated that if there exist negative cycle then return -1;
        for(ArrayList<Integer> current : edges) {
            int u = current.get(0);
            int v = current.get(1);
            int wt = current.get(2);
            if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
