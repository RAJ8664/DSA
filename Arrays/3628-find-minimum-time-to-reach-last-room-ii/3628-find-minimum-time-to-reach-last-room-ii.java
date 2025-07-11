class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[2], b[2]));
        long[][][] dist = new long[n][m][2];
        for (long curr[][] : dist) for (long curr1[] : curr) Arrays.fill(curr1, Long.MAX_VALUE / 10);
        pq.offer(new long[]{0, 0, 0, 0});
        dist[0][0][0] = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long x = current[0];
            long y = current[1];
            long time = current[2];
            long x1 = current[3];
            if (x == n - 1 && y == m - 1) return (int)(time);
            for (int[] dire : dir) {
                int newX = (int)(x + dire[0]);
                int newY = (int)(y + dire[1]);
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    long to_add = 0;
                    if (x1 == 1) to_add = 2;
                    else to_add = 1;
                    long current1 = (long)(Math.max(time, moveTime[newX][newY])) + to_add;
                    if (current1 < dist[newX][newY][(int)x1]) {
                        dist[newX][newY][(int)x1] = current1;
                        pq.offer(new long[]{newX, newY, current1, 1 - x1});
                    }
                }
            }
        }
        return -1;
    }
}