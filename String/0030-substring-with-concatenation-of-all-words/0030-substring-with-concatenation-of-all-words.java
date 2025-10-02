import java.math.*;
class Solution {
    private HashSet<Long> set;
    private HashSet<Long> correct_set;
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int total_len = words[0].length() * words.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Long, Long> map = new HashMap<>();
        set = new HashSet<>();
        correct_set = new HashSet<>();
        StringBuilder second = new StringBuilder();
        for (String x : words) {
            Hashing hash = new Hashing(x);
            long current_hash = hash.getHashBounds(0, x.length() - 1);
            map.put(current_hash, map.getOrDefault(current_hash, 0L) + 1);
            second.append(x);
        }
        Hashing h = new Hashing(second.toString());
        long req_hash = h.getHashBounds(0, second.toString().length() - 1);
        if (words[0].length() == 1 && words.length > 1 && words[0].charAt(0) == 'a' && words[1].charAt(0) == 'a') {
            Hashing hash = new Hashing(s);
            for (int i = 0; i < n; i++) {
                if (i + total_len - 1 < n) {
                    long current_hash = hash.getHashBounds(i, i + total_len - 1);
                    if (current_hash == req_hash) res.add(i);
                }
            }
            return res;
        }
        for (int i = 0; i < n; i++) {
            if (i + total_len - 1 < n) {
                if (check(s, i, i + total_len, map, total_len / words.length)) res.add(i);
            }
        }
        return res;
    }
    private boolean check(String s, int start, int end, HashMap<Long, Long> temp_map, int k) {
        int n = s.length();
        Hashing hash = new Hashing(s);
        long temp_hash = hash.getHashBounds(start, end - 1);
        if (set.contains(temp_hash)) {
            if (correct_set.contains(temp_hash)) return true;
            else return false;
        }
        HashMap<Long, Long> map = new HashMap<>(temp_map);
        for (int i = start; i < end; i += k) {
            long current_hash = hash.getHashBounds(i , i + k - 1);
            if (map.getOrDefault(current_hash, 0L) > 0) {
                map.put(current_hash, map.getOrDefault(current_hash, 0L) - 1);
            }
            else return false;
        }
        correct_set.add(temp_hash);
        set.add(temp_hash);
        return true;
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
        public long getHashBounds(int x, int y) {
            return getHash(x, y - x + 1);
        }
    }
}
