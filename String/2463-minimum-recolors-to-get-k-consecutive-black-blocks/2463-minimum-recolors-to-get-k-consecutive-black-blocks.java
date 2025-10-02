class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int ans = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < k; i++) {
            char current = blocks.charAt(i);
            if (current == 'W') count++;
        }
        int start = 0;
        ans = Math.min(ans, count);
        for (int i = k; i < n; i++) {
            char prev = blocks.charAt(start);
            char current = blocks.charAt(i);
            if (prev == 'W') count--;
            if (current == 'W') count++;
            ans = Math.min(ans, count);
            start++;
        }
        return ans;
    }
}