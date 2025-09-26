class Solution {
    static int mod = (int)(1337);
    public int superPow(int a, int[] b) {
        long res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = mul(res, fast_pow(a, b[i], mod));
            a = (int)(fast_pow(a, 10, mod));
        }
        return (int)(res);
    }
    static long fast_pow(long a, long p, long mod) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                a = ((a % mod) * (a % mod)) % mod;
                p /= 2;
            }
            else {
                res = ((res % mod) * (a % mod)) % mod;
                p--;
            }
        }
        return res;
    }
    static long mul(long a, long b) {return (long) ((long) ((a % mod) * 1L * (b % mod)) % mod);}
}
