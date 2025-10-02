class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0 , right = 0;
        int count = 0;
        while (left < n) {
            while (right < n && map.size() < 3) {
                map.put(s.charAt(right) , map.getOrDefault(s.charAt(right) , 0) + 1);
                right++;
            }
            if(map.size() == 3) count += s.length() - (right) + 1;
            map.put(s.charAt(left) , map.getOrDefault(s.charAt(left) , 0) -1);
            if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
            left++;
        }
        return count;
    }
}