class Solution {
    public int[][] intervalIntersection(int[][] arr, int[][] brr) {
        List<int[]> res = new ArrayList();
        for (int i = 0, j = 0; i < arr.length && j < brr.length;) {
            int start = Math.max(arr[i][0], brr[j][0]);
            int end = Math.min(arr[i][1], brr[j][1]);
            if (start <= end) res.add(new int[]{start, end});
            if (arr[i][1] < brr[j][1]) i++;
            else j++;
        }
        return res.toArray(new int[0][]);
    }
}