class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int low = 1, high = (int)(1e9);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, nums, maxOperations)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    private boolean check(int mid, int arr[], int k) {
        int n = arr.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (count > k) return false;
            count += (arr[i] - 1) / mid;
        }
        return count <= k;
    }
}