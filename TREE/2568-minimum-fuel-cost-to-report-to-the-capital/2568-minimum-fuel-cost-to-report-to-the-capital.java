class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private long answer;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int curr[] : roads) {
            int u = curr[0]; int v = curr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        answer = 0;
        dfs(0, -1, seats);
        return answer;
    }

    private long dfs(int u , int par, int seats) {
        long res = 1;
        for (int v : adj.get(u)) {
            if (v != par) res += dfs(v, u, seats); 
        }
        if (u > 0) answer += (res + seats - 1) / seats;
        return res;
    }
}