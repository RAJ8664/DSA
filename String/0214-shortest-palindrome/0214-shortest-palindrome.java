import java.math.BigInteger;
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(Is_Pallindrome(s)) return s;

        long pref[] = new long[n];
        long suff[] = new long[n];

        Hashing hash = new Hashing(s);
        Hashing hash1 = new Hashing(new StringBuilder(s).reverse().toString());

        for(int i = 0; i < n; i++) pref[i] = hash.getHashbounds(0, i);
        for(int i = n - 1; i >= 0; i--) suff[i] = hash1.getHashbounds(i , n - 1);
        for(int i = 0; i < n / 2; i++) {
            long temp = suff[i];
            suff[i] = suff[n - 1 - i];
            suff[n - 1 - i] = temp;
        }
        int maxi = 0;
        for(int i = 0; i < n - 1; i++) if (pref[i] == suff[i]) maxi = i;
        String current = s.substring(maxi + 1, n);
        String ans = new StringBuilder(current).reverse().toString();
        ans += s;
        return ans;
    }
    static boolean Is_Pallindrome(String s) {
        int n = s.length();
        int low = 0, high = n - 1;
        while(low <= high) {
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
    static class Hashing {
        long[] hash1, hash2;
        long[] inv1, inv2;
        int n;
        static int multiplier = 43;
        static final Random rnd = new Random();
        static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int invMultiplier1 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod1)).intValue();
        static final int invMultiplier2 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod2)).intValue();
        public Hashing(String s) {
            n = s.length();
            hash1 = new long[n + 1];hash2 = new long[n + 1];
            inv1 = new long[n + 1];inv2 = new long[n + 1];
            inv1[0] = 1;inv2[0] = 1;
            long p1 = 1;long p2 = 1;
            for (int i = 0; i < n; i++) {
                hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
                p1 = p1 * multiplier % mod1;
                inv1[i + 1] = inv1[i] * invMultiplier1 % mod1;
                hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
                p2 = p2 * multiplier % mod2;
                inv2[i + 1] = inv2[i] * invMultiplier2 % mod2;
            }
        }
        public long getHash(int i, int len) {
            return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32) + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;
        }
        public long getHashbounds(int x, int y) {
            return getHash(x,y-x+1);
        }
    }
}
