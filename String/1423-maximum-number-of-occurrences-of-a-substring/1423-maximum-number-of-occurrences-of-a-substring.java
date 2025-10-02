class Solution {
    private HashMap<String, Integer> map;
    private int maxi;
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        map = new HashMap<>(); maxi = 0;
        for (int i = minSize; i <= maxSize; i++) getSubstringsOfLengthK(s, i, maxLetters);
        return maxi;
    }
    private ArrayList<String> getSubstringsOfLengthK(String s, int k, int maxLetters) {
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + k <= n) {
                String current = s.substring(i, i + k);
                HashSet<Character> set = new HashSet<>();
                for (int j = 0; j < current.length(); j++) set.add(current.charAt(j));
                if (set.size() <= maxLetters) map.put(current, map.getOrDefault(current, 0) + 1);
                maxi = Math.max(maxi, map.getOrDefault(current, 0));
            }
        }
        return res;
    }
}