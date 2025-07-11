class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int ele : row) sb.append(ele ^ row[0]);
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            res = Math.max(res, map.get(s));
        }
        return res;
    }
}