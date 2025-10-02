class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int i = 0; i <= n; i++){
            st.push(num++);
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()) sb.append(st.pop()); 
            }
        }
        return sb.toString();
    }
}