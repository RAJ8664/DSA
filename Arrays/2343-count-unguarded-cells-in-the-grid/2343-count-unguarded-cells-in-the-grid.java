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
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair current = (Pair)(obj);
            return current.row == row && current.col == col;
        }
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    private HashSet<Pair> bad_cell;
    private HashSet<Pair> wall;
    private HashSet<Pair> guard;
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        bad_cell = new HashSet<>();
        wall = new HashSet<>();
        guard = new HashSet<>();
        for (int curr[] : guards) guard.add(new Pair(curr[0], curr[1]));
        for (int curr[] : walls) wall.add(new Pair(curr[0], curr[1]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (guard.contains(new Pair(i, j))) fill_bad(i, j, n, m);
            }
        }       
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!wall.contains(new Pair(i, j)) && !bad_cell.contains(new Pair(i, j)) && !guard.contains(new Pair(i, j))) {
                    count++;
                }
            }
        } 
        return count;
    }

    private void fill_bad(int row, int col, int n , int m) {
        int cr = row, cc = col;
        //up;
        cr--;
        while (cr >= 0) {
            if (!wall.contains(new Pair(cr, cc))) bad_cell.add(new Pair(cr, cc));
            else break;
            if (guard.contains(new Pair(cr, cc))) break;
            cr--;
        }
        //down
        cr = row + 1;
        cc = col;
        while (cr < n) {
            if (!wall.contains(new Pair(cr, cc))) bad_cell.add(new Pair(cr, cc));
            else break;
            if (guard.contains(new Pair(cr, cc))) break;
            cr++;
        }
        //left;
        cr = row;
        cc = col - 1;
        while (cc >= 0) {
            if (!wall.contains(new Pair(cr, cc))) bad_cell.add(new Pair(cr, cc));
            else break;
            if (guard.contains(new Pair(cr, cc))) break;
            cc--;
        }
        //right;
        cr = row;
        cc = col + 1;
        while (cc < m) {
            if (!wall.contains(new Pair(cr, cc))) bad_cell.add(new Pair(cr, cc));
            else break;
            if (guard.contains(new Pair(cr, cc))) break;
            cc++;
        }
    }
}