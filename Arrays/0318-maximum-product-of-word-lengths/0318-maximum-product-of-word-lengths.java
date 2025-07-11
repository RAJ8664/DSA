class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int freq[][] = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++)
                freq[i][s.charAt(j) - 'a']++;
        }
        int maxi  = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean isCommon = false;
                for (int k = 0; k < 26; k++) {
                    if (freq[i][k] > 0 && freq[j][k] > 0) {
                        isCommon = true;
                        break;
                    }
                }
                if (isCommon == false)
                    maxi = Math.max(maxi, words[i].length() * words[j].length());
            }
        }
        return maxi;
    }
}