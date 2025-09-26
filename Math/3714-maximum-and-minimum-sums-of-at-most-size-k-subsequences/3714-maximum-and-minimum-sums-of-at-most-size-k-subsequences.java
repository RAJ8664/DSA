import java.util.Arrays;

class Solution {
    private long[] factorials = new long[(int)(1e5 + 10)];
    private long[] invFactorials = new long[(int)(1e5 + 10)];
    private int mod = (int)(1e9 + 7);
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        preCompFacts();

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                ans = add(ans, mul((long)(nums[i] * 1L), nCk(n - i - 1, j - 1)));
                ans = add(ans, mul((long)(nums[i] * 1L), nCk(i, j - 1)));
            }
        }
        return (int)(ans);
    }

    private void preCompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    private long nCk(int n, int k) {
        if (n - k < 0)
            return 0;
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    private long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }

    private long add(long a, long b) {
        a += b;
        if (a >= mod)
            a -= mod;
        return a;
    }

    private long mul(long a, long b) {
        return (long)((long)((a % mod) * 1L * (b % mod)) % mod);
    }


}