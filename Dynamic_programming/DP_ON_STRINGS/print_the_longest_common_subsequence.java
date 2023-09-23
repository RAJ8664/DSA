package Dynamic_programming.DP_ON_STRINGS;
import java.util.Arrays;

public class print_the_longest_common_subsequence {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";
        int ind1 = s.length();
        int ind2 = t.length();
        int dp[][] = new int[ind1 + 1][ind2  + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve_tabu(ind1, ind2 , s, t, dp));

    }

    //using tabulation;
    public static String solve_tabu(int ind1 , int ind2, String s, String t ,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 +  dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = ind1;
        int j = ind2;
        while(i > 0 && j > 0){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            }
            else if(s.charAt(i - 1) > t.charAt(j - 1)){
                i--;
            }
            else{
                j--;
            }
        }
       return sb.reverse().toString();
    }
}
