class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> dig = new Stack<>();
        Stack<Character> ch = new Stack<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) num = num * 10 + (int)(current - '0');
            else {
                if (num > 0) dig.add(num);
                num = 0;
                if (current == ']') {
                    StringBuilder current_string = new StringBuilder();
                    while (ch.size() > 0 && ch.peek() != '[') {
                        current_string.append(ch.peek());
                        ch.pop();
                    }
                    ch.pop();
                    String new_string = current_string.reverse().toString();
                    StringBuilder to_add = new StringBuilder("");
                    for (int j = 0; j < dig.peek(); j++) to_add.append(new_string);
                    dig.pop();
                    for (int j = 0; j < to_add.length(); j++) ch.add(to_add.charAt(j));
                }
                else ch.add(current);
            }
        }
        StringBuilder res = new StringBuilder();
        while (ch.size() > 0) res.append(ch.pop());
        return res.reverse().toString();
    }
}
