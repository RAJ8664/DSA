import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        List<Integer>[] g1 = new ArrayList[n], g2 = new ArrayList[m];
        for (int i = 0; i < n; ++i)
            g1[i] = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            g2[i] = new ArrayList<>();
        for (int[] e : edges1) {
            g1[e[0]].add(e[1]);
            g1[e[1]].add(e[0]);
        }
        for (int[] e : edges2) {
            g2[e[0]].add(e[1]);
            g2[e[1]].add(e[0]);
        }

        int[] depth1 = new int[n], count1 = new int[2];
        bfsDepthParity(g1, depth1, count1);
        int[] depth2 = new int[m], count2 = new int[2];
        bfsDepthParity(g2, depth2, count2);

        int[] ans = new int[n];
        int max2 = Math.max(count2[0], count2[1]);
        for (int i = 0; i < n; ++i) {
            int parity = depth1[i] % 2;
            ans[i] = count1[parity] + max2;
        }
        return ans;
    }

    private void bfsDepthParity(List<Integer>[] g, int[] depth, int[] count) {
        Arrays.fill(depth, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        depth[0] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count[depth[u] % 2]++;
            for (int v : g[u]) {
                if (depth[v] == -1) {
                    depth[v] = depth[u] + 1;
                    q.add(v);
                }
            }
        }
    }
}