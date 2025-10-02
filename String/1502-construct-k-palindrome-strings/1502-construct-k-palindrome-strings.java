class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length(), count = 0;
        if (n < k) return false;
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) if (freq[i] % 2 == 1) count++;
        return count <= k;
    }
}