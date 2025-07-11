class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (String current : words) {
            for (char c : current.toCharArray()) {
                if (c == x) {
                    res.add(idx);
                    break;
                }
                
            }
            idx++;
        }
        return res;
    }
}