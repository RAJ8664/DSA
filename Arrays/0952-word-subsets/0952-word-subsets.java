class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length, m = words2.length;
        int freq[] = new int[26];
        for (int i = 0; i < m; i++) {
            int temp_freq[] = new int[26];
            for (int j = 0; j < words2[i].length(); j++) temp_freq[words2[i].charAt(j) - 'a']++;
            for (int j = 0; j < 26; j++) freq[j] = Math.max(freq[j], temp_freq[j]);
        }
        int vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp_freq[] = new int[26];
            for (int j = 0; j < words1[i].length(); j++) temp_freq[words1[i].charAt(j) - 'a']++;
            for (int j = 0; j < 26; j++) if (temp_freq[j] < freq[j]) vis[i] = 1;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (vis[i] == 0) res.add(words1[i]);
        return res;
    }
}