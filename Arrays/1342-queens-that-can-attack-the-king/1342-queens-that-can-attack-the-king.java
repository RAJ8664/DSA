class Solution {
    static HashSet<Pair> set;
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
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int n = queens.length;
        List<List<Integer>> res = new ArrayList<>();
        set = new HashSet<>();
        for (int pos[] : queens) set.add(new Pair(pos[0] , pos[1]));
        for (int pos[] : queens) {
            if (can_attack(pos[0] , pos[1] , king[0] , king[1])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(pos[0]); temp.add(pos[1]);
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }

    static boolean can_attack(int x, int y , int rx, int ry) {
        int n = 8, m = 8;

        //Right
        int cx = x, cy = y + 1;
        while (cy < m) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cy++;
        }

        //Left
        cx = x; cy = y - 1;
        while (cy >= 0) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cy--;
        }

        //Down
        cx = x + 1; cy = y;
        while (cx < n) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx++;
        }

        //Up
        cx = x - 1; cy = y;
        while (cx >= 0) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx--;
        }

        //Right Upper Diagonal        
        cx = x - 1; cy = y + 1;
        while (cx >= 0 && cy < m) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx--; cy++;
        }

        //Left Upper Diagonal
        cx = x - 1; cy = y - 1;
        while (cx >= 0 && cy >= 0) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx--; cy--;
        }

        //Lower Left Diagonal
        cx = x + 1; cy = y - 1;
        while (cx < n && cy >= 0) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx++; cy--;
        }

        //Lower Right Diagonal
        cx = x + 1; cy = y + 1;
        while (cx < n && cy < m) {
            if (set.contains(new Pair(cx , cy))) break;
            if (cx == rx && cy == ry) return true;
            cx++; cy++;
        }
        return false;
    }
}