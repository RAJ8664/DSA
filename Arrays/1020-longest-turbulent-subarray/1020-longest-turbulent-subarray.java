class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int count = 1, maxi = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) count++;
            else if (i % 2 == 1 && arr[i] < arr[i + 1]) count++;
            else {
                maxi = Math.max(maxi, count);
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);
        count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] < arr[i + 1]) count++;
            else if (i % 2 == 1 && arr[i] > arr[i + 1]) count++;
            else {
                maxi = Math.max(maxi, count);
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}