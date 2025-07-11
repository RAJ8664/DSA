class Solution {
    static class custom_sort implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return Integer.compare(second, first);
        }
    }
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new custom_sort());
        for (int ele : nums) pq.offer(ele);
        int ind = 1;
        while (ind < n) {
            nums[ind] = pq.poll();
            ind += 2;
        }
        ind = 0;
        while (pq.size() > 0) {
            nums[ind] = pq.poll();
            ind += 2;
        }
    }
}