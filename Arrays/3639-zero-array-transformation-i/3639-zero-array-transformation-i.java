class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int arr[] = new int[n];
        for (int current_query[] : queries) {
            int l = current_query[0];
            int r = current_query[1];
            arr[l]++; 
            if (r + 1 < n) arr[r + 1]--;
        }
        for (int i = 1; i < n; i++) arr[i] = arr[i - 1] + arr[i];
        for (int i = 0; i < n; i++) {
            if (arr[i] < nums[i]) return false;
        }
        return true;
    }
}