class WordFilter {
    private HashMap<String, Integer> map;
    public WordFilter(String[] words) {
        int n = words.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String prefix = words[i].substring(0, j + 1);
                for (int k = words[i].length() - 1; k >= 0; k--) {
                    String suffix = words[i].substring(k);
                    map.put(prefix + ":" + suffix , i);
                }
            }
        }
    }
    public int f(String pref, String suff) {
        return map.getOrDefault(pref + ":" + suff , -1);
    }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
