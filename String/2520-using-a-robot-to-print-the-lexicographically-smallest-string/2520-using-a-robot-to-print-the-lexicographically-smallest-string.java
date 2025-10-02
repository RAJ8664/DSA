class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int freq[] = new int[26];
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (check(ch - 1, freq)) {
                st.add(ch);
                freq[ch]--;
            }
            else {
                sb.append((char)(ch + 'a'));
                freq[ch]--;
                while (st.size() > 0 && !check(st.peek() - 1, freq)) {
                    sb.append((char)(st.pop() + 'a'));
                }
            }
        }
        while (st.size() > 0) sb.append((char)(st.pop() + 'a'));
        return sb.toString();
    }
    private boolean check(int ch, int freq[]) {
        for (int i = 0; i <= ch; i++) if (freq[i] > 0) return true;
        return false;
    }
}