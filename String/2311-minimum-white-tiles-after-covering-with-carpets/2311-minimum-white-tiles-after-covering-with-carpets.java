import java.util.Arrays;

class Solution {
    private int dp[][];
    private int suff[];
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        suff = new int[n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (floor.charAt(i) == '1')
                count++;
            suff[i] = count;
        }

        dp = new int[n + 1][numCarpets + 1];
        for (int current[] : dp)
            Arrays.fill(current, -1);
        return solve(0, numCarpets, floor, carpetLen);
    }

    private int solve(int ind, int carpetsLeft, String floor, int carpetLen) {
        if (ind >= floor.length())
            return 0;
        if (carpetsLeft == 0)
            return suff[ind];

        if (dp[ind][carpetsLeft] != -1)
            return dp[ind][carpetsLeft];

        int op1 = solve(ind + 1, carpetsLeft, floor, carpetLen) + (floor.charAt(ind) == '1' ? 1 : 0);
        int op2 = solve(ind + carpetLen, carpetsLeft - 1, floor, carpetLen);

        return dp[ind][carpetsLeft] = Math.min(op1, op2);
    }
}