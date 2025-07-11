class Solution {
    public int numberOfArrays(int[] arr, int lower, int upper) {
        int n = arr.length;
        int pref[] = new int[n];
        pref[0] = arr[0];
        for (int i = 1; i < n; i++) pref[i] = pref[i - 1] + arr[i];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            a = Math.min(a, pref[i]);
            b = Math.max(b, pref[i]);
            if (b - a > upper - lower) return 0;
        }
        return (upper - lower) - (b - a) + 1;
    }
}