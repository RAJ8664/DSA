package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][amount + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        if(amount == 0){
            System.out.println(0);
        }
        if(solve(n - 1, arr, amount , dp) >= (int)Math.pow(10,9)){
            System.out.println(-1);
        }
        else{
            System.out.println(solve(n - 1, arr, amount ,dp));
        }
    }


    //memoization;
    public static int solve(int ind , int arr[],int amount , int dp[][]){
        if(ind == 0){
            if(amount % arr[0] == 0){
                return amount / arr[0];
            }
            return (int)Math.pow(10,9);
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int not_take = solve(ind - 1, arr, amount ,dp);
        int take = Integer.MAX_VALUE;
        if(arr[ind] <= amount){
            take = 1 + solve(ind , arr, amount - arr[ind],dp);
        }
        return dp[ind][amount] = Math.min(take , not_take);
    }

    //Tabulation;
    public static int solve_tabu(int n ,int target, int arr[],int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        for(int t = 0; t <=target; t++){
            if(t % arr[0] == 0){
                dp[0][t] = t / arr[0];
            }
            else{
                dp[0][t] = (int)Math.pow(10,8);
            }
        }
        for(int ind = 1; ind < n; ind ++){
            for(int c = 0; c <= target; c++){
                int not_take = dp[ind - 1][c];
                int take = Integer.MAX_VALUE;
                if(arr[ind] <= c){
                    take = 1 + dp[ind][c - arr[ind]];
                }
                dp[ind][c] = Math.min(take, not_take);
            }
        }
        return dp[n - 1][target];
    }
}
