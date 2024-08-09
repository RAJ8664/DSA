package Template;

import java.util.ArrayList;
import java.util.Collections;

class LCA1 {
    public static void main(String[] args) {

    }

    static  class LCA {
        //don't forget to build the lca;
        int N, LOG;
        ArrayList<ArrayList<Integer>> adj;
        int[][] anc;
        int[] dep;

        public LCA(int n) {
            N = n + 1;
            LOG = Integer.numberOfTrailingZeros(Integer.highestOneBit(N)) + 1;
            dep = new int[N];
            adj = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }
            anc = new int[N][LOG];
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public void build(int root) {
            dfs(root, 0);
            for (int i = 1; i < LOG; i++) {
                for (int j = 1; j < N; j++) {
                    anc[j][i] = anc[anc[j][i - 1]][i - 1];
                }
            }
        }

        private void dfs(int u, int p) {
            dep[u] = dep[p] + 1;
            anc[u][0] = p;
            for (int i = 1; i < LOG; i++) {
                anc[u][i] = anc[anc[u][i - 1]][i - 1];
            }
            for (int v : adj.get(u)) {
                if (v == p) continue;
                dfs(v, u);
            }
        }

        public int getLCA(int u, int v) {
            if (dep[u] < dep[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            // Bring u and v to the same depth
            for (int i = LOG - 1; i >= 0; i--) {
                if (dep[u] - (1 << i) >= dep[v]) {
                    u = anc[u][i];
                }
            }
            if (u == v) return u;
            for (int i = LOG - 1; i >= 0; i--) {
                if (anc[u][i] != anc[v][i]) {
                    u = anc[u][i];
                    v = anc[v][i];
                }
            }
            return anc[u][0];
        }

        public int query(int u, int v) {
            int lca = getLCA(u, v);
            return dep[u] + dep[v] - 2 * dep[lca];
        }
    }

}


