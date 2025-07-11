class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long count = 0;
        Arrays.sort(nums);
        return solve(nums, upper) - solve(nums, lower - 1);
    }
    private long solve(int arr[], int sum) {
        int n = arr.length;
        long res = 0;
        int start = n - 1;
        for (int i = 0; i < start; i++) {
            while (i < start && arr[i] + arr[start] > sum) start--;
            res += start - i;
        }
        return res;
    }
}