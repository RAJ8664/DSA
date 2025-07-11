import java.util.Arrays;

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        for (int ele : coins) {
            if (ele > res) break;
            res += ele;
        }
        return res;
    }
}