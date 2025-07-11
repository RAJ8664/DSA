class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = values[i] - i;
        int maxi = Integer.MIN_VALUE;
        int suff_maxi[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxi = Math.max(maxi, arr[i]);
            suff_maxi[i] = maxi;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int current_sum = values[i] + i;
            current_sum += (suff_maxi[i + 1]);
            res = Math.max(res, current_sum);
        }
        return res;
    }
}