class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        s1 += " "; s2 += " ";
        int n = s1.length(), m = s2.length();
        HashSet<String> first = new HashSet<>();
        HashSet<String> second = new HashSet<>();
        HashSet<String> firstR = new HashSet<>();
        HashSet<String> secondR = new HashSet<>();
        String current = "";
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == ' ') {
                if (first.contains(current)) {
                    first.remove(current);
                    firstR.add(current);
                }
                if (!firstR.contains(current)) first.add(current);
                current = "";
            }
            else current += s1.charAt(i);
        }
        current = "";
        for (int i = 0; i < m; i++) {
            if (s2.charAt(i) == ' ') {
                if (second.contains(current)) {
                    secondR.add(current);
                    second.remove(current);
                }
                if (!secondR.contains(current)) second.add(current);
                current = "";
            }
            else current += s2.charAt(i);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String temp : first) if (!second.contains(temp)) if (!res.contains(temp) && !firstR.contains(temp) && !secondR.contains(temp)) res.add(temp);
        for (String temp : second) if (!first.contains(temp)) if (!res.contains(temp) && !firstR.contains(temp) && !secondR.contains(temp)) res.add(temp);
        String answer[] = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }
}
