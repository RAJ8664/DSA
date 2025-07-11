class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(si(nums) , sd(nums));
    }
    public static int si(int arr[]) {
        int n = arr.length;
        int count = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                if (j == i) count++;
                else {
                    if(arr[j] > arr[j - 1]) count++;
                    else break;
                }
                maxi = Math.max(maxi,  count);
            }
        }
        return maxi;
    }
    public static int sd(int arr[]) {
        int n = arr.length;
        int count = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                if (j == i) count++;
                else {
                    if(arr[j] < arr[j - 1]) count++;
                    else break;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}