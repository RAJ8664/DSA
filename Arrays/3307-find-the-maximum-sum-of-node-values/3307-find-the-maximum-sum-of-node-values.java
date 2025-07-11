class Solution {
     public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long  res = 0;
        int count = 0; long maxi = (long)(1e9);
        for(int i =0 ; i < n; i++) {
            int l = nums[i] ^ k;
            if(l > nums[i]) {
                count++;
                res += l; maxi = Math.min(maxi,l - nums[i]);
            }
            else {
                res += nums[i];maxi = Math.min(maxi,nums[i] - l);
            }
        }
        return count % 2 == 0 ? res : res - maxi;
    }
}