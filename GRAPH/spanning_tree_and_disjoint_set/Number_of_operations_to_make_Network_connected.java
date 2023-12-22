package GRAPH.spanning_tree_and_disjoint_set;
import java.util.Scanner;


//class DSU {
//    int parent[] = new int[(int)(1e6)];
//    int size[] = new int[(int)(1e6)];
//    public DSU(int v) {
//        for(int i = 0; i <= v; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//    }
//    public int find(int v) {
//        if(v == parent[v]) return v;
//        return parent[v] = find(parent[v]);
//    }
//    public void unite(int a, int b) {
//        a = find(a);
//        b = find(b);
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


public class Number_of_operations_to_make_Network_connected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;
    }

    public static int makeConnected(int n, int[][] connections) {
        DSU ds = new DSU(n + 1);
        int count = 0;
        for(int current[] : connections) {
            int u = current[0];
            int v = current[1];
            u = ds.find(u);
            v = ds.find(v);
            if(u != v) ds.uniteR(u,v);
            else count++;
        }
        int cc = 0;
        for(int i = 0; i < n; i++) {
            if(i == ds.find(i)) cc++;
        }
        if(cc > count + 1) return -1;
        return cc - 1;
    }
}
