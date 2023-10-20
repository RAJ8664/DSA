package Dynamic_programming.DP_ON_STOCKS;

import java.util.Arrays;
import java.util.Scanner;

public class buy_and_sell_stocks5_cooldown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 2][3];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        //int ans = solve_memo(arr,0,1,dp);
        int ans = solve_tabu(arr,n,dp);
        System.out.println(ans);
    }

    //memoization solution;
    public static int solve_memo(int arr[],int ind, int buy, int dp[][]){
        if(ind >= arr.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            int x = -arr[ind] + solve_memo(arr,ind + 1, 0, dp);
            int y = solve_memo(arr,ind + 1, 1, dp);
            profit = Math.max(x,y);
        }
        else{
            int x = arr[ind] + solve_memo(arr,ind + 2, 1, dp);
            int y = solve_memo(arr,ind + 1, 0, dp);
            profit = Math.max(x,y);
        }
        return dp[ind][buy] = profit;
    }

    //tabulation solution;
    //make sure to declare dp[][] = dp[n + 2][2];
    public static int solve_tabu(int arr[],int n , int dp[][]){
        for(int row[] : dp){
            Arrays.fill(row, 0);
        }
        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = Integer.MIN_VALUE;
                if(buy == 1){
                    int x = -arr[ind] + dp[ind + 1][0];
                    int y = dp[ind + 1][1];
                    profit = Math.max(x,y);
                }
                else{
                    int x = arr[ind] + dp[ind + 2][1];
                    int y = dp[ind + 1][0];
                    profit = Math.max(x,y);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
