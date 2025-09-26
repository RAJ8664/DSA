class Solution {
    public int maxDiff(int num) {
        String  s = Integer.toString(num);
        int maxi = 0, mini = 0;
        int maxi_ind = -1, mini_ind = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                maxi_ind = i;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (maxi_ind == -1)
                maxi = maxi * 10 + (ch - '0');
            else if (ch == s.charAt(maxi_ind))
                maxi = maxi * 10 + 9;
            else
                maxi = maxi * 10 + ch - '0';
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1' && s.charAt(i) != '0') {
                mini_ind = i;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mini_ind == -1)
                mini = mini * 10 + (ch - '0');
            else if (ch == s.charAt(mini_ind) && mini_ind == 0)
                mini = mini * 10 + 1;
            else if (ch == s.charAt(mini_ind) && mini_ind != 0)
                mini = mini * 10 + 0;
            else
                mini = mini * 10 + ch - '0';
        }
        return maxi - mini;
    }
}

