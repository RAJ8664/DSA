package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Frog_jump_with_k_distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp,-1);
            solve(arr,n - 1,k,dp);
        }
    }

    //memoization;
    public static int solve(int[] arr,int ind,int k,int[] dp){
        if(ind == 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int min = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(ind - j >= 0){
                int energy = solve(arr,ind - j,k,dp) + Math.abs(arr[ind] - arr[ind - j]);
                min = Math.min(min,energy);
            }
        }
        return dp[ind] = min;
    }


    //tabulation
    public static int solver(int[] arr,int n,int k,int[] dp){
        dp[0] = 0;
        for(int ind = 1; ind < n; ind++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(ind - j >= 0){
                    int energy = dp[ind - j] + Math.abs(arr[ind] - arr[ind - j]);
                    min = Math.min(min,energy);
                }
            }
            dp[ind] = min;
        }
        return dp[n - 1];
    }
}
