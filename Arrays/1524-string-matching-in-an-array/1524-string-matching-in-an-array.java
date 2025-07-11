class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (check(words[j], words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
    private boolean check(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return false;
        for (int i = 0; i < n; i++) {
            if (i + m - 1 >= n) break;
            String current = s.substring(i, i + m);
            if (current.equals(t)) return true;
        }
        return false;
    }
}