class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int prefEven[] = new int[n];
        int prefOdd[] = new int[n];
        int suffEven[] = new int[n];
        int suffOdd[] = new int[n];

        if (n == 1)
            return 1;

        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                evenSum += nums[i];
            else
                oddSum += nums[i];
            prefEven[i] = evenSum;
            prefOdd[i] = oddSum;
        }

        evenSum = 0;
        oddSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0)
                evenSum += nums[i];
            else
                oddSum += nums[i];
            suffEven[i] = evenSum;
            suffOdd[i] = oddSum;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (suffEven[i + 1] == suffOdd[i + 1])
                    count++;
            } else if (i == n - 1) {
                if (prefEven[i - 1] == prefOdd[i - 1])
                    count++;
            } else {
                evenSum = prefEven[i - 1];
                oddSum = prefOdd[i - 1];
                evenSum += suffOdd[i + 1];
                oddSum += suffEven[i + 1];
                if (evenSum == oddSum)
                    count++;

            }
        }
        return count;
    }
}