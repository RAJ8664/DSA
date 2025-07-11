class SegmentTree {
    int n;
    int[] tree;
    SegmentTree(int sz) {
        n = 1;
        while (n < sz) {
            n <<= 1;
        }
        tree = new int[2 * n];
    }
    void set(int ind, int val) {
        ind += n;
        tree[ind] = val;
        ind >>= 1;
        while (ind > 0) {
            tree[ind] = Math.min(tree[2 * ind], tree[2 * ind + 1]);
            ind >>= 1;
        }
    }
    int get(int x) {
        int node = 1;
        while (node < n) {
            int left = (node << 1);
            int right = (node << 1) + 1;
            if (tree[left] < x) {
                node = left;
            } else {
                node = right;
            }
        }
        return (node - n);
    }
}

public class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int first[];
    private int last[];
    private ArrayList<Integer> euler_tour;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) adj.get(parents[i]).add(i);
        euler_tour = new ArrayList<>();
        euler_tour.add(0);
        first = new int[n + 1];
        last = new int[n + 1];
        dfs(0, nums);
        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) queries.add(new int[]{first[i], last[i]});
        return solve(euler_tour, queries);
    }

    private void dfs(int u, int[] nums) {
        euler_tour.add(nums[u]);
        first[u] = euler_tour.size() - 1;
        for (int v : adj.get(u)) {
            dfs(v, nums);
        }
        last[u] = euler_tour.size() - 1;
    }

    private int[] solve(List<Integer> a, List<int[]> queries) {
        int n = a.size();
        for (int i = 1; i < a.size(); i++) a.set(i, a.get(i) - 1);
        int q = queries.size();
        List<List<int[]>> queryList = new ArrayList<>();
        for (int i = 0; i <= n; i++) queryList.add(new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int l = queries.get(i)[0];
            int r = queries.get(i)[1];
            queryList.get(r).add(new int[]{l, i});
        }
        List<Integer> res = new ArrayList<>(q);
        for (int i = 0; i < q; i++) res.add(0);
        SegmentTree s = new SegmentTree((int)(1e5 + 1));
        for (int i = 1; i < n; i++) {
            s.set(a.get(i), i);
            for (int[] query : queryList.get(i)) {
                int l = query[0];
                int ind = query[1];
                res.set(ind, s.get(l) + 1);
            }
        }
        int fans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) fans[i] = res.get(i);
        return fans;
    }
}

