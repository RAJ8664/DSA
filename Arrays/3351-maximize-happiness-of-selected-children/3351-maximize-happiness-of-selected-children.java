
import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long sum = 0, count = 0;;
        Arrays.sort(happiness);
        for (int i = n - 1; i >= 0; i--) {
            if (k > 0) {
                k--;
                sum += Math.max(0, happiness[i] - count);
                count++;
            }
        }
        return sum;
    }
}