package Dynamic_programming.DP_ON_STOCKS;

import java.util.Arrays;
import java.util.Scanner;

public class Best_time_to_buy_and_sell_stocks2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int dp[][] = new int[n + 1][3];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve_tabu(arr,n,dp);
        System.out.println(ans);

    }

    //recursive solution
    public static int solve_recursion(int arr[],int ind, int buy,int dp[][]){
        if(ind == arr.length) return 0;

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            int x = -arr[ind] + solve_recursion(arr,ind + 1, 0,dp);
            int y = solve_recursion(arr,ind + 1, 1, dp);
            profit = Math.max(x, y);
        }
        else{
            int x = arr[ind] + solve_recursion(arr,ind + 1, 1, dp);
            int y = solve_recursion(arr,ind + 1, 0, dp);
            profit = Math.max(x, y);
        }
        return profit;
    }
    //1 = liberty to buy;
    //0 = cannot buy;

    //memoization solution
    public static int solve_memo(int arr[],int ind, int buy,int dp[][]){
        if(ind == arr.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            int x = - arr[ind] + solve_memo(arr,ind + 1, 0,dp);
            int y = 0 + solve_memo(arr,ind + 1, 1, dp);
            profit = Math.max(x,y);

        }
        else{
            int x = arr[ind] + solve_memo(arr,ind + 1, 1, dp);
            int y = solve_memo(arr,ind + 1, 0, dp);
            profit = Math.max(x, y);
        }
        return dp[ind][buy] = profit;
    }

    //tabulation solution
    public static int solve_tabu(int arr[],int n,int dp[][]){
        for(int row[] : dp){
            Arrays.fill(row,0);
        }
        dp[n][0] = dp[n][1] = 0;
        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <=1; buy++){
                int profit = Integer.MIN_VALUE;
                if(buy == 1){
                    int x = -arr[ind] + dp[ind + 1][0];
                    int y = dp[ind + 1][1];
                    profit = Math.max(x,y);
                }
                else{
                    int x = arr[ind] + dp[ind + 1][1];
                    int y = dp[ind + 1][0];
                    profit = Math.max(x,y);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];

    }
}
