class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            char current = s.charAt(i);
            if(Character.isDigit(current)) st.add(current);
            else {
                if(st.size() > 0 && Character.isDigit(st.peek())) st.pop();
                else st.add(current);
            }
        }
        String res = "";
        while(st.size() > 0)  res += st.pop();
        return res;
    }
}