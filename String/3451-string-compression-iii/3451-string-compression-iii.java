class Solution {
    public String compressedString(String word) {
        if (word == null || word.length() == 0) return "";
        StringBuilder comp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char current = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == current && count < 9) count++;
            else {
                stack.push(count + "" + current);
                current = c;
                count = 1;
            }
        }
        stack.push(count + "" + current);
        while (!stack.isEmpty()) comp.insert(0, stack.pop());
        return comp.toString();
    }
}