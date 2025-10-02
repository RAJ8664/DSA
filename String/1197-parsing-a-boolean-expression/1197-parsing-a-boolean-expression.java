class Solution {
    public boolean parseBoolExpr(String s) {
        int n = s.length();
        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == ',') continue;
            if (current == '&' || current == '|' || current == '!') second.add(current);
            else {
                if (current == ')') {
                    char todo = second.pop();
                    if (todo == '&') {
                        boolean flag = true;
                        while (first.size() > 0 && first.peek() != '(') {
                            char ch = first.pop();
                            if (ch == 'f') flag = false;
                        }
                        first.pop();
                        if (flag == true) first.add('t');
                        else first.add('f');
                    }
                    else if (todo == '|') {
                        boolean flag = false;
                        while (first.size() > 0 && first.peek() != '(') {
                            char ch = first.pop();
                            if (ch == 't') flag = true;
                        }
                        first.pop();
                        if (flag == true) first.add('t');
                        else first.add('f');
                    }
                    else if (todo == '!') {
                        char ch = first.pop();
                        first.pop();
                        if (ch == 't') first.add('f');
                        else first.add('t');
                    }
                }
                else first.add(current);
            }
        }
        if (first.peek() == 't') return true;
        return false;
    }
}