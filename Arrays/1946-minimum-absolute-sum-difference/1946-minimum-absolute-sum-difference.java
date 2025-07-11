class Solution {
    private static int mod = (int)(1e9 + 7);
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(nums1[i]);
        long current_res = 0, current_mini = 0;
        for (int i = 0; i < n; i++) current_res += Math.abs(nums1[i] - nums2[i]);
        current_mini = current_res;
        for (int i = 0; i < n; i++) {
            Integer ceil = set.ceiling(nums2[i]);
            Integer floor = set.floor(nums2[i]);
            if (ceil != null) {
                long temp = current_res;
                temp -= Math.abs(nums1[i] - nums2[i]);
                temp += Math.abs(nums2[i] - ceil);
                current_mini = Math.min(current_mini, temp);
            }
            if (floor != null) {
                long temp = current_res;
                temp -= Math.abs(nums1[i] - nums2[i]);
                temp += Math.abs(nums2[i] - floor);
                current_mini = Math.min(current_mini, temp);
            }
        }
        return (int)(current_mini % mod);
    }
}