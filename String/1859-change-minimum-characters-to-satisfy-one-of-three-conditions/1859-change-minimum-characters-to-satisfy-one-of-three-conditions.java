class Solution {
    public int minCharacters(String a, String b) {
        int n = a.length(), m = b.length();

        int op1 = calcDistinct(a, b);

        int freq1[] = new int[26], freq2[] = new int[26];
        for (int i = 0; i < n; i++)
            freq1[a.charAt(i) - 'a']++;
        for (int i = 0; i < m; i++)
            freq2[b.charAt(i) - 'a']++;

        int cx = 0, cy = 0;
        for (int i = 0; i < 25; i++) {
            cx += freq1[i];
            cy += freq2[i];
            op1 = Math.min(op1, Math.min(n - cx + cy, m - cy + cx));
        }
        return op1;
    }
    private int calcDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int freq1[] = new int[26], freq2[] = new int[26];
        for (int i = 0; i < n; i++)
            freq1[s.charAt(i) - 'a']++;
        for (int i = 0; i < m; i++)
            freq2[t.charAt(i) - 'a']++;
        int maxi1 = 0, maxi2 = 0;
        for (int i = 0; i < 26; i++) {
            maxi1 = Math.max(maxi1, freq1[i]);
            maxi2 = Math.max(maxi2, freq2[i]);
        }
        return n - maxi1 + m - maxi2;
    }
}