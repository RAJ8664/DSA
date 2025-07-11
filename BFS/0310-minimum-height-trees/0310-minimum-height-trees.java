class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> ans = new ArrayList<>();
        int degree[] = new int[n + 1];
        for(int i = 0; i < n; i++) degree[i] = adj.get(i).size();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) if (degree[i] == 1) q.offer(i);
        while(n > 2) {
            int len = q.size();
            n = n - len;
            for(int i = 0; i < len; i++) {
                int current = q.peek();
                q.poll();
                for(int child : adj.get(current)) {
                    degree[child]--;
                    if(degree[child] == 1) q.offer(child);
                }
            }
        }
        res.addAll(q);
        if(res.size() == 0) {
            res.add(0);
            return res;
        }
        return res;
    }
}