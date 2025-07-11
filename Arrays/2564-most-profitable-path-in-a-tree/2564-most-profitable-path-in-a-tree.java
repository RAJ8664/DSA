class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int parent[];
    private int time[];
    private class Pair {
        int node, cost, current_time;
        public Pair(int node, int cost, int current_time) {
            this.node = node;
            this.cost = cost;
            this.current_time = current_time;
        }
        @Override
        public String toString() {
            return "(" + node + " " + cost + " " + current_time + ")";
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair current = (Pair)(obj);
            return current.node == node && current.cost == cost && current.current_time == current_time;
        }
        @Override
        public int hashCode() {
            return Objects.hash(node, cost, current_time);
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int maxi = Integer.MIN_VALUE;
        adj = new ArrayList<>();
        for (int i = 0; i <= (int)(1e5 + 1); i++) adj.add(new ArrayList<>());
        for (int current[] : edges) {
            int u = current[0];
            int v = current[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            maxi = Math.max(maxi, u);
            maxi = Math.max(maxi, v);
        }
        int n = maxi;
        parent= new int[n + 1];
        parent[0] = -1;
        fill_parent(0, -1, parent);
        time = new int[n + 1];
        Arrays.fill(time, -1);
        fill_time(time, bob);
        ArrayList<Integer> leaf = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == 1) leaf.add(i); 
        }
        int vis[] = new int[n + 1];
        int res[] = new int[n + 1];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, amount[0], 0));
        vis[0] = 1;
        res[0] = amount[0];
        while (q.size() > 0) {
            int current_node = q.peek().node;
            int current_cost = q.peek().cost;
            int current_time = q.peek().current_time;
            q.poll();
            for (int v : adj.get(current_node)) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    if (current_time + 1 == time[v]) res[v] = res[current_node] + amount[v] / 2;
                    else if(current_time + 1 < time[v] || time[v] == -1) res[v] = amount[v] + res[current_node];
                    else res[v] = res[current_node];
                    q.offer(new Pair(v, res[v] , current_time + 1));
                }
            }
        }
        int maxi_ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == 1) maxi_ans = Math.max(maxi_ans, res[i]);
        }
        return maxi_ans;
    }
    private void fill_time(int time[] , int bob) {
        int current_time = 0;
        time[bob] = current_time;
        int pos = bob;
        while (pos != -1) {
            time[pos] = current_time++;
            pos = parent[pos];
        }
    }
    private void fill_parent(int u , int par, int parent[]) {
        for (int v : adj.get(u)) {
            if (v != par) {
                parent[v] = u;
                fill_parent(v, u , parent);
            }
        }
    }
}