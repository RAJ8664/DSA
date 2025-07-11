class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            if (ele >= 0) {
                if (i + ele < n) ans[i] = nums[i + ele];
                else ans[i] = nums[(i + ele) % n];
            }
            else {
                if (i - Math.abs(ele) >= 0) ans[i] = nums[i - Math.abs(ele)];
                else ans[i] = nums[(i - Math.abs(ele) % n + n) % n];
            }
        }
        return ans;
    }
}