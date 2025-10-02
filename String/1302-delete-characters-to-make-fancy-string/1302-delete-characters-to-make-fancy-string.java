class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        char prev = '1';
        int count = 0;
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == prev && count == 2) {
                continue;
            }
            if (current == prev && count == 0) {
                count = 2;
                res.append(current);
                prev = current;
            }
            else {
                res.append(current);
                prev = current;
                count = 0;
            }
        }
        return res.toString();   
    }

}