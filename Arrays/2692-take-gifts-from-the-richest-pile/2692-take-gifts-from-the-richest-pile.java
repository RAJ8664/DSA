class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        long ans = 0;
        for (int i : gifts) {
            q.offer(i);
            ans += i;
        }
        while (k-- >0) {
            int v = q.poll();
            ans -= (v - (int) Math.sqrt(v));
            q.offer((int) Math.sqrt(v));
        }
        return ans;
    }
}