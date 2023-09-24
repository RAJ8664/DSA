package Dynamic_programming.DP_ON_STRINGS;

import java.util.Arrays;
import java.util.Scanner;

public class edit_distance {
    //read the problem statement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int ind1 = s.length();
        int ind2 = t.length();
        int dp[][] = new int[ind1 + 1][ind2 + 1];
        for(int temp[]: dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve_recursion(ind1 - 1, ind2 - 1, s, t));
        System.out.println(solve_memo(ind1 - 1, ind2 - 1, s, t, dp));
        System.out.println(solve_tabu(ind1, ind2 , s, t, dp));
    }

    //recursion;
    public static int solve_recursion(int ind1, int ind2 , String s, String t){
        if(ind1 < 0){
            return ind2 + 1;
        }
        if(ind2 < 0){
            return ind1 + 1;
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            return solve_recursion(ind1 - 1, ind2 - 1, s, t);
        }
        int delete = 1 + solve_recursion(ind1 - 1, ind2, s, t);
        int insert = 1 + solve_recursion(ind1, ind2 - 1, s, t);
        int replace = 1 + solve_recursion(ind1 -1 , ind2 - 1, s, t);
        return Math.min(Math.min(insert, replace),delete);
    }

    //memoization;
    public static int solve_memo(int ind1, int ind2 , String s, String t,int dp[][]){
        if(ind1 < 0){
            return ind2 + 1;
        }
        if(ind2 < 0){
            return ind1 + 1;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = solve_memo(ind1 - 1, ind2 - 1, s, t,dp);
        }
        int delete = 1 + solve_memo(ind1 - 1, ind2, s, t,dp);
        int insert = 1 + solve_memo(ind1, ind2 - 1, s, t,dp);
        int replace = 1 + solve_memo(ind1 -1 , ind2 - 1, s, t,dp);
        return dp[ind1][ind2] = Math.min(Math.min(insert, replace),delete);
    }

    
    //tabulation;
    public static int solve_tabu(int ind1, int ind2, String s, String t,int dp[][]){
        for(int temp[] :dp){
            Arrays.fill(temp , 0);
        }
        for(int i = 0; i <= ind1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= ind2; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int delete = 1 + dp[i - 1][j];
                    int insert = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(delete, Math.min(insert,replace));

                }
            }
        }
        return dp[ind1][ind2];
    }
}
