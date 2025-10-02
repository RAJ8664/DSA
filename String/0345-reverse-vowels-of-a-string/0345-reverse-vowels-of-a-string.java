class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (isVowel(current)) res.add(i);
        }
        Collections.reverse(res);
        int k = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (isVowel(current)) ans += s.charAt(res.get(k++));
            else ans += current;
        }
        return ans;
    }
    private boolean isVowel(char current) {
        if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') return true;
        if (current == 'A' || current == 'E' || current == 'I' || current == 'O' || current == 'U') return true;
        return false;
    }
}
