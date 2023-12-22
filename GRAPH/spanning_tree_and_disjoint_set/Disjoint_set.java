package GRAPH.spanning_tree_and_disjoint_set;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class DSU{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DSU(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int find(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = find(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void uniteR(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void uniteS(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


public class Disjoint_set {
    public static void main(String[] args) {
        //find the connected components in the graph;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        DSU ds = new DSU(n);
        while(e-->0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds.uniteR(u,v);
        }
        int count = 0;
        for(int i = 0; i <= n; i++) {
            if(ds.find(i) == i) count++;
        }
        System.out.println(count);

    }
}
