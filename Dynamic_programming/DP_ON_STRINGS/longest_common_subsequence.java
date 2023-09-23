package Dynamic_programming.DP_ON_STRINGS;

import java.util.Arrays;

public class longest_common_subsequence {
    //read the problem statement first;
    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        int ind1 = s.length();
        int ind2 = t.length();


        int dp[][] = new int[ind1 + 2][ind2 + 2];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve_recursion(ind1 - 1, ind2 - 1, s, t));
        System.out.println(solve_memo(ind1 - 1, ind2 - 1, s, t,dp));
        System.out.println(solve_tabu(ind1 , ind2, s, t,dp));

    }

    //recursion;
    public static int solve_recursion(int ind1, int ind2,String s, String t){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            return 1 + solve_recursion(ind1 - 1, ind2 - 1, s, t);
        }
        return Math.max(solve_recursion(ind1 - 1, ind2,  s, t), solve_recursion(ind1 , ind2 - 1 , s, t));
    }

    //memoization;
    public static int solve_memo(int ind1 , int ind2 , String s, String t, int dp[][]){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = 1 + solve_memo(ind1 - 1 , ind2 - 1, s, t, dp);
        }
        return dp[ind1][ind2] = Math.max(solve_memo(ind1 - 1, ind2 , s, t, dp) , solve_memo(ind1 , ind2 - 1, s, t, dp));
    }

    //Tabulation;
    public static int solve_tabu(int ind1 , int ind2, String s, String t ,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }

        //base case in not required since we have already filled with zeroes above;
        //we are going till ind1 because we have shifted our indexing to 1 to right side;
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
        //same reason of shifting instead of dp[ind1 - 1][ind2 - 1] we did dp[ind1][ind2];
        return dp[ind1][ind2];
    }

}
