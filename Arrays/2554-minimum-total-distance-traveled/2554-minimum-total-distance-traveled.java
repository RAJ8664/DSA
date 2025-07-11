class Solution {
    static class Pair {
        long first, second;
        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return "(" + first + " " + second + ")";
        }
    }
    static class custom_sort implements Comparator<int[]> {
        @Override
        public int compare(int first[] , int second[]) {
            return Integer.compare(first[0] , second[0]);
        }
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int m = robot.size();
        int n = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, new custom_sort());
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i < m; i++) dp[i][n] = Long.MAX_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            long prefix = 0;
            Deque<Pair> qq = new ArrayDeque<>();
            qq.offer(new Pair(m, 0L));
            for (int i = m - 1; i >= 0; i--) {
                prefix += Math.abs(robot.get(i) - factory[j][0]);
                while (!qq.isEmpty() && qq.peekFirst().first > i + factory[j][1]) qq.pollFirst();
                while (!qq.isEmpty() && qq.peekLast().second >= dp[i][j + 1] - prefix) qq.pollLast();
                qq.offerLast(new Pair(i, dp[i][j + 1] - prefix));
                dp[i][j] = qq.peekFirst().second + prefix;
            }
        }
        return dp[0][0];
    }
}