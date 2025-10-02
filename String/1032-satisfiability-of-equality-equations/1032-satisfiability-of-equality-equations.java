class Solution {
    static class DSU {
        private int parent[];
        private int size[];
        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find_parent(int u) {
            if (parent[u] == u) return parent[u] = u;
            return parent[u] = find_parent(parent[u]);
        }
        public void unite(int u , int v) {
            u = find_parent(u);
            v = find_parent(v);
            if (u == v) return;
            if (size[v] > size[u]) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent[v] = u;
            size[u] += size[v];
        }
    }
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        DSU dsu = new DSU(30);
        for (int i = 0; i < n; i++) {
            int u = equations[i].charAt(0) - 'a';
            int v = equations[i].charAt(3) - 'a';
            char current = equations[i].charAt(1);
            if (current == '=') dsu.unite(u, v);
        }
        for (int i = 0; i < n; i++) {
            int u = equations[i].charAt(0) - 'a';
            int v = equations[i].charAt(3) - 'a';
            char current = equations[i].charAt(1);
            if (current == '!') {
                u = dsu.find_parent(u);
                v = dsu.find_parent(v);
                if (u == v) return false;
            }
        }
        return true;
    }
}
