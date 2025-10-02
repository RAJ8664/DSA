class Solution {
    public char findKthBit(int n, int k) {
        String dp[] = new String[n + 1];
        dp[1] = "0";
        if (n == k) if (k == 1) return '0';
        dp[2] = "011";
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + "1" + reverse(invert(dp[i - 1]));
        }
        String ans = dp[n];
        return ans.charAt(k - 1);
    }

   private String invert(String s){
        int n = s.length();
        StringBuilder inv = new StringBuilder();
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '1'){
                inv.append('0');
            }else{
                inv.append('1');
            }
        }
        return inv.toString();
    }

    private String reverse(String s){
        StringBuilder rev = new StringBuilder(s);
        return rev.reverse().toString();
    }
}