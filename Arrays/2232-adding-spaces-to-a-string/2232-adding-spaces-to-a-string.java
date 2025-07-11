class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        Arrays.sort(spaces);
        int current = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (current < spaces.length && i == spaces[current]) {
                current++;
                res.append(" ");
                res.append(ch);
            }
            else res.append(ch);
        }
        return res.toString();
    }
}