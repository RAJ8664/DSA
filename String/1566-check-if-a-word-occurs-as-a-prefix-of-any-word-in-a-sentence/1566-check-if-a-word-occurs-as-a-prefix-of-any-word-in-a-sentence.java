class Solution {
    public int isPrefixOfWord(String sentence, String target) {
        int n = sentence.length();
        ArrayList<String> res = new ArrayList<>();
        sentence += " ";
        String current = "";
        for (int i = 0; i < sentence.length(); i++) {
            char curr = sentence.charAt(i);
            if (curr == ' ') {
                res.add(current);
                current = "";
            }
            else current += curr;
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).startsWith(target)) return i + 1;
        }
        return -1;
    }
}