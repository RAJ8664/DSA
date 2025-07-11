class Solution {
    public int largestCombination(int[] arr) {
        int n = arr.length;
        int dp[] = new int[32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if (((arr[i] >> j) & 1) > 0) dp[j]++;
            }
        }
        int maxi = 1;
        for (int ele : dp) maxi = Math.max(maxi, ele);
        return maxi;
    }
}