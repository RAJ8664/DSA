class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
            }
            if (count > 2) return false;
        }
        return (count == 2 && set1.equals(set2) || count == 0);
    }
}