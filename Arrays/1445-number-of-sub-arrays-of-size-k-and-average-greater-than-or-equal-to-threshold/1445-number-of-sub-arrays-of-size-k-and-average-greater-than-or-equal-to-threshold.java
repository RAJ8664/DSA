class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        long sum = 0; int count = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        if (sum / k >= threshold) count++;
        int start = 0;
        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[start++];
            if (sum / k >= threshold) count++;
        }
        return count;
    }
}