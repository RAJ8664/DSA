class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 1, high = n, ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, nums, k)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }   
        return ans;
    }

    private boolean ok(int mid, int arr[], int k) {
        int n = arr.length;
        long current_sum = 0;
        for (int i = 0; i < mid; i++) current_sum += arr[i];
        long req = arr[mid - 1] * 1L * mid;
        long left = req - current_sum;
        if (left  <= k) return true;
        int start = 0;
        for (int i = mid; i < n; i++) {
            current_sum += arr[i];
            current_sum -= arr[start];
            req = arr[i] * 1L * mid;
            left = req - current_sum;
            if (left <= k) return true;
            start++;
        }
        return false;
    }
}