class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long white = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') res += white;
            else white++;
        }
        return res;
    }
}