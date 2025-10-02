class Solution {
    public boolean isCircularSentence(String sentence) {
        sentence += " ";
        int n = sentence.length();
        ArrayList<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sentence.charAt(i) == ' ') {
                res.add(temp.toString());
                temp = new StringBuilder();
            }
            else temp.append(sentence.charAt(i));
        }
        System.out.println(res);
        if (res.size() == 1) {
            String current = res.get(0);
            if (current.charAt(0) != current.charAt(current.length() - 1)) return false;
        } 
        for (int i = 0; i < res.size() - 1; i++) {
            String current = res.get(i);
            String next = res.get(i + 1);
            if (current.charAt(current.length() - 1) != next.charAt(0)) return false;
        }
        if (res.size() > 1) {
            String current = res.get(0);
            String next = res.get(res.size() - 1);
            if (current.charAt(0) != next.charAt(next.length() - 1)) return false;
        }
        return true;
    }
}