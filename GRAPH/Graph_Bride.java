package Template;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph_Bride {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Graph_Bridge graph = new Graph_Bridge(n + 1);
        for(int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.add_Edge(u , v);
        }
        count = 0;
        graph.bridge_DFS();
        System.out.println(count);
    }

    static class Graph_Bridge {
        private int V;
        private LinkedList<Integer> adj_list[];
        int t = 0;
        static final int NIL = -1;

        Graph_Bridge(int v) {
            V = v;
            adj_list = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj_list[i] = new LinkedList();
        }

        void add_Edge(int u, int v) {
            adj_list[u].add(v);
            adj_list[v].add(u);
        }

        void check_bridge(int u, boolean visited[], int discovered[], int low[], int parent[]) {
            visited[u] = true;
            discovered[u] = t + 1;
            low[u] = t + 1;
            t = t + 1;

            Iterator<Integer> i = adj_list[u].iterator();
            while (i.hasNext()) {
                int v = i.next();
                if (!visited[v]) {
                    parent[v] = u;
                    check_bridge(v, visited, discovered, low, parent);
                    low[u] = Math.min(low[u], low[v]);

                    if (low[v] > discovered[u])
                        count++;
                } else if (v != parent[u])
                    low[u] = Math.min(low[u], discovered[v]);
            }
        }
        void bridge_DFS() {
            boolean visited[] = new boolean[V];
            int discovered[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
            }
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    check_bridge(i, visited, discovered, low, parent);
        }
    }
}
