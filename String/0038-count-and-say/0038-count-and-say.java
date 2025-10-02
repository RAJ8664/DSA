class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == 1) res.append("1");
            else {
                String current = res.toString();
                res = new StringBuilder();
                res.append(findRLE(current));
            }
        }
        return res.toString();
    }
    private String findRLE(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);
            if (current == prev) count++;
            else {
                res.append(count);
                res.append(prev);
                count = 1;
                prev = current;
            }
        }
        if (count > 0) {
            res.append(count);
            res.append(prev);
        }
        return res.toString();
    }
}