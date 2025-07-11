class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0L;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0, j = 0; j < nums.length; ++j){
            k -= count.getOrDefault(nums[j],0);
            count.put(nums[j],count.getOrDefault(nums[j],0)+1);
            while(k <= 0){
                count.put(nums[i],count.get(nums[i])-1);
                k += count.get(nums[i++]);
            }
            res += i;
        }
        return res;
    }
}