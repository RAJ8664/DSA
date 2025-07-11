class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length, m = groups[0].length;
        int currIdx = 0;
        RangeHash Hash = new RangeHash(nums);
        for (int i = 0; i < n; i++) {
            RangeHash reqHash = new RangeHash(groups[i]);
            boolean flag = false;
            for (int j = currIdx; j < nums.length; j++) {
                if (j + groups[i].length - 1 < nums.length) {
                    if (Hash.getRangeHash(j, j + groups[i].length - 1) == reqHash.getRangeHash(0, groups[i].length - 1)) {
                        currIdx = j + groups[i].length;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false)
                return false;
        }
        return true;
    }
    public class RangeHash {
        private long[] prefixHash;
        private long[] powBase;
        private final int base = 31;
        private final int mod = 1_000_000_007;

        public RangeHash(int[] arr) {
            int n = arr.length;
            prefixHash = new long[n + 1];
            powBase = new long[n + 1];
            powBase[0] = 1;
            for (int i = 0; i < n; i++) {
                prefixHash[i + 1] = (prefixHash[i] * base + arr[i]) % mod;
                powBase[i + 1] = (powBase[i] * base) % mod;
            }
        }

        public long getRangeHash(int l, int r) {
            long hash = (prefixHash[r + 1] - prefixHash[l] * powBase[r - l + 1] % mod + mod) % mod;
            return hash;
        }
    }
}