class Solution {
    public char kthCharacter(int k) {
        StringBuilder current = new StringBuilder();
        current.append("a");
        while (true) {
            if (current.length() >= k)
                break;
            StringBuilder newString = new StringBuilder();
            String tempCurrent = current.toString();
            for (int i = 0; i < tempCurrent.length(); i++) {
                char c = tempCurrent.charAt(i);
                if (c == 'z')
                    newString.append('a');
                else
                    newString.append((char)(c + 1));
            }
            current.append(newString);
        }
        return current.toString().charAt(k - 1);
    }
}