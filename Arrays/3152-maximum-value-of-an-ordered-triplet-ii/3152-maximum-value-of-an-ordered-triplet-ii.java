class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pref_maxi[] = new int[n];
        int suff_maxi[] = new int[n];
        int maxi = nums[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            pref_maxi[i] = maxi;
        }
        maxi = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxi = Math.max(maxi, nums[i]);
            suff_maxi[i] = maxi;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i + 2 < n) {
                int left = pref_maxi[i], middle = nums[i + 1], right = suff_maxi[i + 2];
                res = Math.max(res, (left - middle) * 1L * right);
            }
        }
        return res;
    }
}