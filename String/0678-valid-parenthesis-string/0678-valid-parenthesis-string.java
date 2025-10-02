class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == '(') st.add(i);
            else if (current == '*') star.add(i);
            else {
                if (st.size() > 0) st.pop();
                else if (st.size() == 0 && star.size() == 0) return false;
                else star.pop();
            }
        }
        while (st.size() > 0 && star.size() > 0) {
            if (st.peek() > star.peek()) return false;
            else {
                st.pop();
                star.pop();
            }
        }
        return st.size() == 0;
    }
}