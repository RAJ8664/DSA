import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private int dp[][];
    private int mod = (int)(1e9 + 7);

    public int specialPerm(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][(1 << n) + 1];
        for (int current[] : dp)
            Arrays.fill(current, -1);

        return solve(0, -1, nums, new ArrayList<>());
    }

    private int solve(int ind, int prev, int arr[], ArrayList<Integer> selected) {
        if (selected.size() == arr.length)
            return 1;

        int mask = 0;
        for (int ele : selected)
            mask |= (1 << ele);

        if (dp[prev + 1][mask] != -1)
            return dp[prev + 1][mask];

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!selected.contains(i)) {
                if (prev == -1 || arr[i] % arr[prev] == 0 || arr[prev] % arr[i] == 0) {
                    selected.add(i);
                    res = (res + solve(ind + 1, i, arr, selected)) % mod;
                    selected.remove(selected.size() - 1);
                }
            }
        }
        return dp[prev + 1][mask] = res;
    }
}