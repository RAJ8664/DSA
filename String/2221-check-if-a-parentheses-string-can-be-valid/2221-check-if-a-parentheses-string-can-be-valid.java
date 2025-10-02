class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;
        int bal = 0;
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == '(' || locked.charAt(i) == '0') bal++;
            else bal--;
            if (bal < 0) return false;
        }
        bal = 0;
        for (int i = n - 1; i >= 0; i--) {
            char current = s.charAt(i);
            if (current == ')' || locked.charAt(i) == '0') bal++;
            else bal--;
            if (bal < 0) return false;
        }
        return true;
    }
}