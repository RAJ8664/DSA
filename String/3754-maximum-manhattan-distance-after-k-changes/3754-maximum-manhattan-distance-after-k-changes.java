class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        char[][] dir = new char[][]{{'N', 'E'}, {'N', 'W'},{'S', 'E'},{'S', 'W'}};
        for (char[] d: dir) {
            for (int i = 0, curr = 0, t = k; i < s.length(); ++i){
                if (s.charAt(i) == d[0] || s.charAt(i) == d[1]){
                    if(t > 0 ) { t--; curr++; }
                    else 
                        curr--;
                }
                else 
                    curr++;
                ans = Math.max(ans, curr); 
            }
        }
        return ans;
    }
}