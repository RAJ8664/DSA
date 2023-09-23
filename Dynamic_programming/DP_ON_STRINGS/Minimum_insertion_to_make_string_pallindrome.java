package Dynamic_programming.DP_ON_STRINGS;
import java.util.Arrays;
import java.util.Scanner;

public class Minimum_insertion_to_make_string_pallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s2 = sb.toString();
        int dp[][] = new int[n + 1][n + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(n - solve_memo(n - 1, n - 1, s, s2, dp));
    }
    //memoization;
    public static int solve_memo(int n , int m , String s, String t, int dp[][]){
        if(n < 0 || m < 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s.charAt(n) == t.charAt(m)){
            return dp[n][m] = 1 + solve_memo(n - 1, m - 1, s, t, dp);
        }
        return dp[n][m] = Math.max(solve_memo(n - 1, m , s, t, dp) , solve_memo(n , m - 1, s, t, dp));
    }

    //tabulation;
    public static int solve_tabu(int n , int m, String s,String t,int dp[][]){
        for(int temp[]:dp){
            Arrays.fill(temp , 0);
        }
        for(int i = 1; i <= n; i++){
            for(int j =1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i -1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
