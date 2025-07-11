class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int pref[] = new int[n];
        int suff[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            pref[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            suff[n - 1 - i] = sum;
        }
        int maxi = 0;
        for (int left = 0; left <= k; left++) {
            int right = k - left;
            int current_sum = 0;
            if (left - 1 >= 0) current_sum += pref[left - 1];
            if (right - 1 >= 0) current_sum += suff[right - 1];
            maxi = Math.max(maxi, current_sum);
        }
        return maxi;
    }
}