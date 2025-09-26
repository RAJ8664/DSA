class Solution {
    private int mod = (int)(1e9 + 7);
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int even = 1, odd = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                even++;
                res += odd;
            }
            else {
                odd++;
                res += even;
            }
            res = res % mod;
        }
        return res;
    }
}