class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i])
                    return -1;
            }
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums1[i] - nums2[i]) % k != 0)
                return -1;
        }
        long totalInc = 0, totalDec = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] > nums2[i])
                totalDec += 1L * (nums1[i] - nums2[i]) / k;
            else
                totalInc += 1L * (nums2[i] - nums1[i]) / k;
        }
        if (totalInc != totalDec)
            return -1;
        return totalDec;
    }
}