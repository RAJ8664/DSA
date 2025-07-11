class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        int sz = s.length();
        for(var word : dictionary) set.add(word);
        int count[] = new int[sz + 1];
        for(int right = 1; right <= sz; right++){
                count[right] = 1 + count[right-1];
                for(int left = right; left > 0; left--){
                    String word = s.substring(left - 1, right);
                    if(set.contains(word)){
                        count[right] = Math.min(count[right], count[left - 1]);
                    }
                }
        }
        return count[sz];
    }
}