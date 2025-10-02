class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long hash = 0, pow = 1;
        int res = 0;
        for (int i = 0; i < k; i++) {
            pow = (pow * power) % modulo;
        }
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash * power + val) % modulo;
            if (j >= k) {
                int outVal = s.charAt(i + k) - 'a' + 1;
                hash = (hash - outVal * pow % modulo + modulo) % modulo;
            }
            if (j >= k - 1 && hash == hashValue) {
                res = i;
            }
        }
        return s.substring(res, res + k);
    }
}