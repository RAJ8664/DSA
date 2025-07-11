class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxi = 0;
        int pref_maxi[] = new int[n];
        pref_maxi[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) pref_maxi[i] = Math.max(pref_maxi[i + 1], nums[i]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j + 1 < n) maxi = Math.max(maxi, (nums[i] - nums[j]) * 1L * pref_maxi[j + 1]);
            }
        }
        return maxi;
    }
}