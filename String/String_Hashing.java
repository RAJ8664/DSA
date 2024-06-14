package string_algo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class String_Hashing {
    public static void main(String[] args) {

    }

    static class HashedString {
        // Change M and B if you want
        public static final long M = (long)1e9 + 9;
        public static final long B = 9973;
        // pow[i] contains B^i % M
        private static ArrayList<Long> pow = new ArrayList<>();
        // pHash[i] is the hash of the first i characters of the given string
        private long[] pHash;
        public HashedString(char s[]) {
            if (pow.isEmpty()) { pow.add(1L); }
            while (pow.size() <= s.length) {
                pow.add((pow.get(pow.size() - 1) * B) % M);
            }
            pHash = new long[s.length + 1];
            pHash[0] = 0;
            for (int i = 0; i < s.length; i++) {
                pHash[i + 1] = ((pHash[i] * B) % M + s[i]) % M;
            }
        }
        public long getHash(int start, int end) {
            long rawVal =
                    pHash[end + 1] - (pHash[start] * pow.get(end - start + 1));
            return (rawVal % M + M) % M;
        }
    }


    //Try this one;
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
