class Solution {
    private int dist1[];
    private int dist2[];
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        dist1 = getDistance(edges, node1);
        dist2 = getDistance(edges, node2);
        int minDistance = Integer.MAX_VALUE, res = -1;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;
            int dist= Math.max(dist1[i], dist2[i]);
            if (dist < minDistance) {
                res = i;
                minDistance = dist;
            }
        }
        return res;
    }
    private int[] getDistance(int[] edges, int node) {
        int[] res = new int[edges.length];
        Arrays.fill(res, -1);
        int distance = 0;
        while (node != -1 && res[node] == -1) {
            res[node] = distance++;
            node = edges[node];
        }
        return res;
    }
}