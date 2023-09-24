package Dynamic_programming.DP_ON_STRINGS;

import java.util.Arrays;
import java.util.Scanner;

public class count_distinct_subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=  sc.next();
        String t = sc.next();
        int ind1 = s.length();
        int ind2 = t.length();
        int dp[][] = new int[ind1 + 1][ind2 + 1];
        for(int temp[] :dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve_recursion(ind1 - 1, ind2 - 1, s, t));
        System.out.println(solve_memo(ind1 - 1, ind2 -1 , s, t, dp));
        System.out.println(solve_tabu(ind1, ind2, s, t, dp));
    }


    //recursion;
    public static int solve_recursion(int ind1, int ind2, String s, String t){
        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }

        if(s.charAt(ind1) == t.charAt(ind2)){
            return solve_recursion(ind1 - 1, ind2 - 1, s, t) + solve_recursion(ind1 - 1, ind2, s, t);
        }
        return solve_recursion(ind1 - 1, ind2, s,t);
    }

    //memoization;
    public static int solve_memo(int ind1, int ind2, String s, String t, int dp[][]){
        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = (solve_memo(ind1 - 1, ind2 - 1,s, t, dp) + solve_memo(ind1 - 1, ind2, s, t, dp));
        }
        return dp[ind1][ind2] = solve_memo(ind1 - 1, ind2 , s, t, dp);
    }

    //tabulation;

    public static int solve_tabu(int ind1, int ind2, String s, String t, int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        //not matter what my index one is (s) if ind2 < 0 we return 1;
        for(int i = 0; i <= ind1; i++){
            dp[i][0] = 1;
        }

        //not matter what my index two is except first if ind1 < 0 we return 0;
        //except first because they may match at index first;
        for(int i = 1; i<= ind2; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[ind1][ind2];
    }
}
