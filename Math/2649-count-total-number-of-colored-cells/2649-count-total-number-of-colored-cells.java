class Solution {
    public long coloredCells(int n) {
        long res = 1;
        if (n == 1) return res;
        for (int i = 1; i < n; i++) res += 4 * 1L * i;
        return res;   
    }
}