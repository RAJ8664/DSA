class Solution {
    static class Pair {
        long key, value;
        public Pair(long key, long value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "(" + key + " " + value + ")";
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        long current_sum = 0;
        Deque<Pair> q = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            current_sum += nums[r];
            if (current_sum >= k) res = Math.min(res, r + 1);
            while (!q.isEmpty() && current_sum - q.peekFirst().key >= k) {
                Pair front = q.pollFirst();
                res = (int)(Math.min(res, r - front.value));
            }
            while (!q.isEmpty() && q.peekLast().key > current_sum) q.pollLast();
            q.offerLast(new Pair(current_sum, r));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}