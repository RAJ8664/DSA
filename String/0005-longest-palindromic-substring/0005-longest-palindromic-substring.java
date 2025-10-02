import java.math.BigInteger;
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = n; i >= 1; i--) {
            String res = check(s, i);
            if (!res.equals("")) return res;
        }
        String res = "";
        res += s.charAt(0);
        return res;
    }
    private static String check(String s, int len) {
        int n = s.length();
        StringBuilder t = new StringBuilder(s);
        Hashing hash1 = new Hashing(s);
        Hashing hash2 = new Hashing(t.reverse().toString());
        for (int i = 0; i < n; i++) {
            if (i + len - 1 < n) {
                long Hash1 = hash1.getHashbounds(i, i + len / 2 - 1);
                long Hash2 = hash2.getHashbounds(n - (i + len), (n - (i + len) + len / 2 - 1));
                if (Hash1 == Hash2) {
                    StringBuilder res = new StringBuilder();
                    for (int j = i; j <= i + len - 1; j++) res.append(s.charAt(j));
                    return res.toString();
                }
            }
        }
        return "";
    }
    static class Hashing {
        long[] hash1, hash2;
        long[] inv1, inv2;
        int n;
        static int muresiplier = 43;
        static final Random rnd = new Random();
        static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int invMuresiplier1 = BigInteger.valueOf(muresiplier).modInverse(BigInteger.valueOf(mod1)).intValue();
        static final int invMuresiplier2 = BigInteger.valueOf(muresiplier).modInverse(BigInteger.valueOf(mod2)).intValue();
        public Hashing(String s) {
            n = s.length();
            hash1 = new long[n + 1]; hash2 = new long[n + 1];
            inv1 = new long[n + 1]; inv2 = new long[n + 1];
            inv1[0] = 1; inv2[0] = 1;
            long p1 = 1; long p2 = 1;
            for (int i = 0; i < n; i++) {
                hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
                p1 = p1 * muresiplier % mod1;
                inv1[i + 1] = inv1[i] * invMuresiplier1 % mod1;
                hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
                p2 = p2 * muresiplier % mod2;
                inv2[i + 1] = inv2[i] * invMuresiplier2 % mod2;
            }
        }
        public long getHash(int i, int len) {
            return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32) + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;

        }
        public long getHashbounds(int x, int y) {
            return getHash(x, y - x + 1);
        }
    }
}