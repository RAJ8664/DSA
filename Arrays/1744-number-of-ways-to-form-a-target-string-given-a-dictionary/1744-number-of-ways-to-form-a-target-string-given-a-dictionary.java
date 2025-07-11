class Solution {
    public int numWays(String[] words, String target) {
        long dp[] = new long[target.length()]; 
        long mod = 1000000000 + 7;
        for(int i = 0; i < words[0].length(); i++) { 
            int[] freq = new int[26];
            for(String word : words) freq[word.charAt(i) - 'a']++; 
            for(int j = Math.min(i, target.length() - 1); j >= 0; j--) {
                if(freq[target.charAt(j) - 'a'] > 0) { 
                    dp[j] += (j == 0) ? freq[target.charAt(j) - 'a'] : dp[j - 1] * freq[target.charAt(j) - 'a']; 
                    dp[j] %= mod;
                }
            }
        }
        return (int)dp[dp.length - 1];
    }
}