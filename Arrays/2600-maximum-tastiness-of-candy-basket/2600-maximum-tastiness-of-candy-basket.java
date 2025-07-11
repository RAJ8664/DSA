import java.util.Arrays;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = (int)(1e9 + 10), ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, price, k)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
    private boolean ok(int target, int arr[], int k) {
        int n = arr.length;
        k--;
        int current = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - current >= target) {
                current = arr[i];
                k--;
                if (k == 0)
                    return true;
            }
        }
        return false;
    }
}