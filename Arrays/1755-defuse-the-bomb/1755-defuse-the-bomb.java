class Solution {
    public int[] decrypt(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        if (k == 0) return res;
        else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = 1; j <= k; j++) s += arr[(i + j) % n];
                res[i] = s;
            }
        } 
        else if (k < 0) {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = 1; j <= -1 * k; j++) s += arr[(i - j + n) % n];
                res[i] = s;
            }
        }
        return res;
    }
}