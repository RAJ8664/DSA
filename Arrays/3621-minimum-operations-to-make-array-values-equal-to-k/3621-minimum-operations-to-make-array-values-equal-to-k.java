class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int freq[] = new int[101];
        int count = 0;
        for (int ele : nums) {
            freq[ele]++;
            if (ele < k) return -1;
            if (ele != k && freq[ele] == 1) count++;
        }
        return count;
    }
}