class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n  = nums.length;
        int pref[][] = new int[n + 1][33];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 32; j++) pref[i + 1][j] = pref[i][j] + ((nums[i] >> j) & 1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int low = i;
            int high = n - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(check(i, mid , pref, k)) {
                    ans = Math.min(ans, mid - i + 1);
                    high = mid - 1;
                }
                else low = mid + 1;
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public static boolean check(int start, int end, int pref[][], int k) {
        int n = pref.length;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int temp = pref[end + 1][i] - pref[start][i];
            if(temp > 0) res += (1 << i);
        }
        return res >= k;
    }
}