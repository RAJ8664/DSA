class Solution {
    private ArrayList<ArrayList<Pair>> adj;
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> nodes;
    private int vis[];
    static class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return "(" + node + " " + distance + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(first.distance, second.distance);
        }
    }
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
        public void merge(int u , int v) {
            u = Leader(u);
            v = Leader(v);
            if (size[v] > size[u]) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent[v] = u;
            size[u] += size[v];
        }
        public int Leader(int u) {
            if (parent[u] == u) return parent[u] = u;
            return parent[u] = Leader(parent[u]);
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        map = new HashMap<>();
        nodes = new ArrayList<>();
        DSU dsu = new DSU(n + 1);
        adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int current[] : edges) {
            int u = current[0];
            int v = current[1];
            int wt = current[2];
            if (dsu.Leader(u) != dsu.Leader(v)) dsu.merge(u , v);
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        vis = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                nodes.clear();
                dfs(i, -1);
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < nodes.size(); j++) {
                    int u = nodes.get(j);
                    for (int k = 0; k < adj.get(u).size(); k++) temp.add(adj.get(u).get(k).distance);
                }
                if (temp.size() == 0) continue;
                int and = temp.get(0);
                for (int ele : temp) and &= ele;
                if (and != -1) {
                    for (int ele : nodes) map.put(ele, and);
                }
            }
        }
        int res[] = new int[query.length];
        int k = 0;
        for (int current[] : query) {
            int src = current[0];
            int dst = current[1];
            if (dsu.Leader(src) != dsu.Leader(dst)) {
                res[k++] = -1;
                continue;
            }
            res[k++] = map.get(src);
        }
        return res;
    }
    private void dfs(int u , int par) {
        vis[u] = 1;
        nodes.add(u);
        for (int i = 0; i < adj.get(u).size(); i++) {
            int child = adj.get(u).get(i).node;
            if (vis[child] == 0) dfs(child , u);
        }
    }
    private int min_dist(int n , int src, int dst) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)(1e9));
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom_sort());
        for (int i = 0; i < adj.get(src).size(); i++) {
            int child_node = adj.get(src).get(i).node;
            int child_dist = adj.get(src).get(i).distance;
            dist[child_node] = child_dist;
            pq.offer(new Pair(child_node, dist[child_node]));
        }
        while (pq.size() > 0) {
            int current_node = pq.peek().node;
            int current_dist = pq.peek().distance;
            pq.poll();
            for (int i = 0; i < adj.get(current_node).size(); i++) {
                int child_node = adj.get(current_node).get(i).node;
                int child_dist = adj.get(current_node).get(i).distance;
                if (dist[child_node] > (current_dist & child_dist)) {
                    dist[child_node] = current_dist & child_dist;
                    pq.offer(new Pair(child_node, dist[child_node]));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}