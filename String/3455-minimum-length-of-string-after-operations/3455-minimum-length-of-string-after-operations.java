class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0) + 1);
        int total = n;
        for(Map.Entry<Character, Integer> curr : map.entrySet()) {
            char key = curr.getKey();
            int val = curr.getValue();
            int count = 0;
            if(val >= 3) {
                while(val >= 3) {
                    val -= 2;
                    count++;
                }
            }
            total -= count * 2;
        }
        return total;
    }
}