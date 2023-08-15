package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(fibonacci_1(n,dp));
    }



    //memoization
    public static int fibonacci(int n,int[] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fibonacci(n - 1,dp) + fibonacci(n - 2,dp);
        //TC = O(n);
        //SC = O(n) + O(n);
    }


    //Tabulation
    public static int fibonacci_1(int n ,int[]  dp){

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        //TC  = O(n);
        //SC = O(n);

    }
}
