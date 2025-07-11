class Solution {
    static class custom_sort implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return Integer.compare(second, first);
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new custom_sort());
        for(int i = 0; i < n; i++) 
            pq.offer(nums[i]);
        int res[] = new int[k];
        int p = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(k > 0) {
            int ele = pq.poll();
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            k--;
        }
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                res[p++] = nums[i];
                map.put(nums[i] , map.getOrDefault(nums[i] , 0) - 1);
                if(map.get(nums[i]) == 0) 
                    map.remove(nums[i]);
            }
        }
        return res;
    }
}