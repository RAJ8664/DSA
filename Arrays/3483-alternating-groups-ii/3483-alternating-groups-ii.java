class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, res = 0, cnt = 1;
        for (int i = 0; i < n + k - 2; ++i) {
            cnt = colors[i % n] != colors[(i + 1) % n] ? cnt + 1 : 1; 
            if(cnt >= k) res += 1;
        }
        return res;
    }
}