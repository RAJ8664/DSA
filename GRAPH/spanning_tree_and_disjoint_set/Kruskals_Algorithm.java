package GRAPH.spanning_tree_and_disjoint_set;

//class DSU {
//    int parent[] = new int[(int)(1e6)];
//    int size[] = new int[(int)(1e6)];
//
//    public DSU(int v) {
//        for(int i = 0; i <= v; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//    }
//
//    public int find (int v) {
//        if(v == parent[v]) return v;
//        //path compression;
//        return parent[v] = find(parent[v]);
//    }
//    public void unite(int a ,int b) {
//        a = find(a);
//        b = find(b);
//
//        //andhadhoon unite(valid but not good);
////        if(a != b) {
////            parent[b] = a;
////        }
//
//
//        //union by size = use of number of nodes or size of tree --> join smaller tree to larger tree;
//        if(a != b) {
//            if(size[a] <= size[b]) {
//                parent[a] = b;
//                size[b] += size[a];
//            }
//            else {
//                parent[b] = a;
//                size[a] += size[b];
//            }
//        }
//    }
//}


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskals_Algorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;

    }


    public static int kruskalMST(int n,int [][]edges) {
        int sum = 0;
        DSU ds = new DSU(n + 1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int current[] : edges) {
            ArrayList<Integer> temp = new ArrayList<>();
            int u = current[0];
            int v = current[1];
            int wt = current[2];
            temp.add(u);
            temp.add(v);
            temp.add(wt);
            adj.add(temp);
        }

        Collections.sort(adj, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                return Integer.compare(list1.get(2), list2.get(2));
            }
        });

        for(int i = 0; i < adj.size(); i++) {
            int u = adj.get(i).get(0);
            int v = adj.get(i).get(1);
            int wt = adj.get(i).get(2);
            u = ds.find(u);
            v = ds.find(v);
            if(u != v) {
                ds.uniteR(u,v);
                sum += wt;
            }
        }
        return sum;
    }
}
