class Solution {
    private int pref[][];
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        pref = new int[n][32];
        build_and_prefix(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int low = i, high = n - 1, ind1 = -1, ind2 = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int curr = compute_and_in_range(i, mid);
                if(curr > k) low = mid + 1;
                else if (curr <= k) {
                    ind1 = mid;
                    high = mid - 1;
                }
            }
            low = i;
            high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int curr = compute_and_in_range(i, mid);
                if (curr >= k) {
                    low = mid + 1;
                    ind2 = mid;
                }
                else if (curr < k) high = mid - 1;
            }
            if(ind1 != -1 && ind2 != -1) ans += (ind2 - ind1 + 1);
        }
        return ans;
    }

    private void build_and_prefix(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            for (int j = 0; j < 32; j++) {
                int current_bit = ((current >> j) & 1);
                if (i == 0) {
                    if (current_bit > 0) pref[i][j] = 1;
                    else pref[i][j] = 0;
                }
                else { 
                    if (current_bit > 0) pref[i][j] += pref[i - 1][j] + 1;
                    else pref[i][j] = pref[i - 1][j];
                }
            }
        }
    }

    private int compute_and_in_range(int l, int r) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = pref[r][i];
            if (l - 1 >= 0) count -= pref[l - 1][i];
            if (count == r - l + 1) res |= (1 << i);
        }
        return res;
    }
}