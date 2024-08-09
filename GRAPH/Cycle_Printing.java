package Template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class Cycle_Printing {
    //change the constant according to problem statement;
    static ArrayList<ArrayList<Integer>> adj;
    static Vector<Integer>[] graph = new Vector[10000];
    static Vector<Integer>[] cycles = new Vector[10000];
    static int cyclenumber;
    static HashSet<Integer> set;
    //undirected graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            graph[i] = new Vector<>();
            cycles[i] = new Vector<>();
        }
        for(int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u , v);
        }
        set = new HashSet<>();
        int[] color = new int[n + 1];
        int[] par = new int[n + 1];
        int[] mark = new int[n + 1];
        cyclenumber = 0;
        dfs_cycle(1, 0, color, par);
        ArrayList<ArrayList<Integer>> cycles = new ArrayList<>();
        cycles = printCycles();
    }

    static ArrayList<ArrayList<Integer>> printCycles() {
        ArrayList<ArrayList<Integer>> cycle = new ArrayList<>();
        for (int i = 0; i < cyclenumber; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : cycles[i]) temp.add(x);
            cycle.add(new ArrayList<>(temp));
        }
        return cycle;
    }

    static void dfs_cycle(int u, int p, int[] color,int[] par) {
        if (color[u] == 2)  return;
        if (color[u] == 1) {
            Vector<Integer> v = new Vector<Integer>();
            int cur = p;
            v.add(cur);
            while (cur != u) {
                cur = par[cur];
                v.add(cur);
            }
            cycles[cyclenumber] = v;
            cyclenumber++;
            return;
        }
        par[u] = p;
        color[u] = 1;
        for (int v : graph[u]) {
            if (v == par[u]) {
                continue;
            }
            dfs_cycle(v, u, color, par);
        }
        color[u] = 2;
    }

    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }
}
