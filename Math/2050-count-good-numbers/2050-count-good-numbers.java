class Solution {
    static long mod = (long)(1e9 + 7);
    public int countGoodNumbers(long n) {
        long res = fast_pow(5, (n + 1) / 2, mod);        
        res = mul(res, fast_pow(4, n / 2, mod));
        return (int)(res);
    }
    private long fast_pow(long a, long p, long mod) {
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
    private long mul(long a, long b) {return (long) ((long) ((a % mod) * 1L * (b % mod)) % mod);}
}