class Solution {
    private int mod = (int)(1e9 + 7);
    public int countGoodArrays(int n, int m, int k) {
        precompFacts();
        long res = m * exp(m - 1, n - 1 - k) % mod * 1L * nCk(n - 1, n - 1 - k ) % mod;
        return (int)(res);
    }
    private long fast_pow(long a, long p, long mod) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                a = ((a % mod) * (a % mod)) % mod;
                p /= 2;
            } else {
                res = ((res % mod) * (a % mod)) % mod;
                p--;
            }
        }
        return res;
    }
    private long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }
    // Factorials and Inverse Factorials;
    private long[] factorials = new long[1_000_01];
    private long[] invFactorials = new long[1_000_01];
    private void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
    private long nCk(int n, int k) {
        // use precompFacts first;
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }
    private long mul(long a, long b) {
        return (long)((long)((a % mod) * 1L * (b % mod)) % mod);
    }
}