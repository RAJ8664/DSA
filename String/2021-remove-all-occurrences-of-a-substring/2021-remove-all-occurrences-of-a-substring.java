class Solution {
    public String removeOccurrences(String s, String part) {
        String res = part;
        while (s.contains(res)){
            s = s.replaceFirst(res,"");
        }
        return s;
    }
}