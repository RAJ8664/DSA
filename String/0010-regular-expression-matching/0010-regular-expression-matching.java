class Solution {
    public boolean isMatch(final String s, final String p) {
        return solve(s, p, 0, 0, new Boolean[s.length()][p.length()]);
    }
    private boolean solve(String s, String p, final int i, final int j, final Boolean[][] dp) {
        if(i >= s.length() && j >= p.length()) return true;
        if(j >= p.length()) return false;
        if(i < s.length() && dp[i][j] != null) return dp[i][j];
        final boolean op1 = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            final boolean op2 = solve(s, p, i, j + 2, dp) || (op1 && solve(s, p, i + 1, j, dp));
            if(i < s.length()) dp[i][j] = op2;
            return op2;
        }
        if(op1) return dp[i][j] = solve(s, p , i + 1, j + 1, dp);
        if(i < s.length()) dp[i][j] = false;
        return false;
    }    
}
