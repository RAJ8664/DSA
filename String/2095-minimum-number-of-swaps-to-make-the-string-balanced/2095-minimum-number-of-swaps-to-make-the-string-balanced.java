class Solution {
    public int minSwaps(String s) {
        int n = s.length(), count = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == '[') st.add(current);
            else {
                if (st.size() == 0) count++;
                else st.pop();
            }
        }
        int ans = count / 2;
        if (count % 2 == 1) ans++;
        return ans;
    }
}
