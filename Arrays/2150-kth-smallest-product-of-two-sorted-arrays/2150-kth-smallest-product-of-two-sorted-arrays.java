class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n = nums1.length, m = nums2.length;
        long low = -((long)(1e12)), high = (long)(1e12);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (ok(nums1, nums2, mid, k))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    private boolean ok(int arr[], int brr[], long req, long k) {
        int n = arr.length, m = brr.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (req >= 0)
                    count += m;
                continue;
            } else if (arr[i] < 0) {
                int low = 0, high = m - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[i] * 1L * brr[mid] <= req)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
                count += m - low;
            } else {
                int low = 0, high = m - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[i] * 1L * brr[mid] <= req)
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
                count += low;
            }
        }
        return count < k;
    }
}