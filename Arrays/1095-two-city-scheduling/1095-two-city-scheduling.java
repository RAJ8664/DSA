
import java.util.Arrays;

class Solution {
    private int dp[][][];

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        dp = new int[n + 1][n / 2 + 1][n / 2 + 1];
        for (int current[][] : dp)
            for (int current1[] : current)
                Arrays.fill(current1, -1);
        int res = solve(0, n / 2, n / 2, costs);
        return res;
    }

    private int solve(int ind, int aCount, int bCount, int cost[][]) {
        if (ind >= cost.length) {
            if (aCount > 0 || bCount > 0)
                return Integer.MAX_VALUE / 10;
            return 0;
        }
        if (dp[ind][aCount][bCount] != -1)
            return dp[ind][aCount][bCount];
        /* Need to decide whether to move this person to city A or B */
        int op1 = Integer.MAX_VALUE / 10, op2 = Integer.MAX_VALUE / 10;
        if (aCount > 0)
            op1 = cost[ind][0] + solve(ind + 1, aCount - 1, bCount, cost);
        if (bCount > 0)
            op2 = cost[ind][1] + solve(ind + 1, aCount, bCount - 1, cost);
        return dp[ind][aCount][bCount] = Math.min(op1, op2);
    }
}