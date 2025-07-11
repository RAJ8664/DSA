class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0, neg = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += Math.abs(matrix[i][j]);
                neg = Math.min(neg, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) count++;
            }
        }
        if (count % 2 == 1) return sum - neg * 2;
        return sum;
    }
}