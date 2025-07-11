class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int ele : nums) pq.offer((long)(ele));
        int count = 0;
        while (pq.size() > 0) {
            if (pq.size() >= 2) {
                long first = pq.poll();
                long second = pq.poll();
                if (first >= k) break;
                pq.offer(2 * 1L *  Math.min(first, second) + Math.max(first, second));
                count++;
            }
            else break;
        }
        return count;    
    }
}