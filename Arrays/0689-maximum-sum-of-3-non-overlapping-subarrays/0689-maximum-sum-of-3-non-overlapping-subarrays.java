class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        int windowSum = 0;
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                sums[i - k + 1] = windowSum;
                windowSum -= nums[i - k + 1];
            }
        }
        int[] left = new int[sums.length];
        int leftMaxIndex = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[leftMaxIndex]) {
                leftMaxIndex = i;
            }
            left[i] = leftMaxIndex;
        }

        int[] right = new int[sums.length];
        int rightMaxIndex = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[rightMaxIndex]) {
                rightMaxIndex = i;
            }
            right[i] = rightMaxIndex;
        }

        int maxSum = 0;
        int[] result = new int[3];
        for (int mid = k; mid < sums.length - k; mid++) {
            int l = left[mid - k], r = right[mid + k];
            int totalSum = sums[l] + sums[mid] + sums[r];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result = new int[] {l, mid, r};
            }
        }
        return result;
    }
}