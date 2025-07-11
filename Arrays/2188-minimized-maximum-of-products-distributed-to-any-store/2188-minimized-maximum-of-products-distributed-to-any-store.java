class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int maxi = 0;
        for (int ele : quantities) maxi = Math.max(maxi, ele);
        int low = 1;
        int high = maxi;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, quantities, n)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }

    private boolean ok(int mid, int arr[], int n) {
        int sum = 0;
        for (int ele : arr) sum += (ele + mid - 1) / mid;
        return sum > n;
    }
}