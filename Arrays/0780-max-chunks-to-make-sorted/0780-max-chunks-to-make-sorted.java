class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
            if (i == maxi) count++;
        }
        return count;
    }
}