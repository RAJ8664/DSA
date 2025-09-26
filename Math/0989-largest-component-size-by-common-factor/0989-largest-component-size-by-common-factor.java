class Solution {
    private HashMap<Integer, ArrayList<Integer>> map;
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
        public void unite(int u, int v) {
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
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        map = new HashMap<>();
        int maxi_ele = 0; for (int ele : nums) maxi_ele = Math.max(maxi_ele, ele);
        DSU dsu = new DSU(maxi_ele + 1);
        for (int i = 0; i < n; i++) compute_div(nums[i]);
        for (Map.Entry<Integer, ArrayList<Integer>> curr : map.entrySet()) {
            ArrayList<Integer> res = curr.getValue();
            for (int i = 0; i < res.size() - 1; i++) {
                int u = res.get(i), v = res.get(i + 1);
                dsu.unite(u, v);
            }
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            if (dsu.find_parent(current) == current) maxi = Math.max(maxi, dsu.size[current]);
        }
        return maxi;
    }
    private void compute_div(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (!map.containsKey(i)) map.put(i, new ArrayList<>());
                map.get(i).add(n);
                if (n / i != i) {
                    if (!map.containsKey(n / i)) map.put(n / i, new ArrayList<>());
                    map.get(n / i).add(n);
                }
            }
        }
        if (!map.containsKey(n)) map.put(n, new ArrayList<>());
        map.get(n).add(n);
    }
}
