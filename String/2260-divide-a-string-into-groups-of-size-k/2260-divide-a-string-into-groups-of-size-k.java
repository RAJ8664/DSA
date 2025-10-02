class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String res[] = new String[n / k];
        if (n % k != 0) 
            res = new String[n / k + 1];
        StringBuilder current = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            current.append(s.charAt(i));
            if (current.toString().length() == k) {
                res[idx++] = current.toString();
                current = new StringBuilder();
            }
        }
        while (current.toString().length() != k) 
            current.append(fill);
        if (idx < res.length) 
            res[idx++] = current.toString();
        return res;
    }
}