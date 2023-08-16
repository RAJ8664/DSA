package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_non_adjacent_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(solve(arr,n - 1, dp));
        }
    }

    //memoization
    public static int solve(int[] arr,int ind,int[] dp){
        if(ind == 0){
            return arr[0];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = arr[ind] + solve(arr,ind - 2, dp);
        int not_pick = solve(arr,ind - 1 , dp);
        return dp[ind] = Math.max(pick,not_pick);
    }

    //tabulation
    public static int solver(int[] arr,int ind, int[] dp){
        dp[0] = arr[0];
        for(int i = 1; i < ind; i++){
            int pick = arr[i];
            if(i > 1){
                pick  += dp[i - 2];
            }
            int not_pick  = dp[i - 1];
            dp[i] = Math.max(not_pick,pick);
        }
        return dp[ind - 1];
    }
}
