class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length){
            if (!s1[i].equals(s2[j])) break;
            i++; j++;
        }
        if (i == s1.length || j == s2.length) return true;
        int len1 = s1.length - 1, len2 = s2.length - 1;
        while(len1 >= i && len2 >= j){
            if(!s1[len1].equals(s2[len2])) return false;
            len1--; len2--;
        }
        if (len1 < i || len2 < j) return true;
        return false;
    }
}