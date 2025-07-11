class Solution {
    static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + row + " " + col + ")";
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length;
        int row[] = new int[mat.length];
        int col[]= new int[mat[0].length];
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) map.put(mat[i][j], new Pair(i, j));
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                row[map.get(arr[i]).row]++;
                col[map.get(arr[i]).col]++;
                if (row[map.get(arr[i]).row] == mat[0].length) return i;
                if (col[map.get(arr[i]).col] == mat.length) return i;
            }
        }
        return -1;
    }
}