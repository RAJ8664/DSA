class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int mod[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) mod[i] = 1;
            else mod[i] = 0;
        }
        Map<Integer, Long> m = new HashMap<>();
        int p = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            p = (p + mod[i]) % modulo;
            if (p == k) ans++;
            int rem = p - k;
            if (rem < 0) rem += modulo;
            ans += m.getOrDefault(rem, 0L);
            m.put(p, m.getOrDefault(p, 0L) + 1);
        }
        return ans;
    }
}