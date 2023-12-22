package GRAPH.spanning_tree_and_disjoint_set;

import java.util.*;

//class DSU {
//    int parent[] = new int[(int)(1e6)];
//    int size[] = new int[(int)(1e6)];
//    public DSU (int v) {
//        for(int i = 0; i <= v; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//    }
//
//    public int find(int v) {
//        if(v == parent[v]) return v;
//        return parent[v] = find(parent[v]);
//    }
//
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
public class accounts_merge {
    //Read the problem statement first on leetcode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //do the input part;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n + 1);
        List<List<String>> res = new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String curr = accounts.get(i).get(j);
                if(map.containsKey(curr) == false) {
                    map.put(curr, i);
                }
                else {
                    int val = map.get(curr);
                    ds.uniteR(i, val);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) temp.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            int upar = ds.find(val);
            temp.get(upar).add(key);
        }

        for(int i = 0; i < accounts.size(); i++) {
            List<String> tt = new ArrayList<>();
            if(temp.get(i).size() == 0) continue;
            for(int j = 0; j < temp.get(i).size(); j++) {
                tt.add(temp.get(i).get(j));
            }
            Collections.sort(tt);
            tt.add(0,accounts.get(i).get(0));
            res.add(tt);
        }
        return res;
    }
}
