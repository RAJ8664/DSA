package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Rod_cutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight[] = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = i + 1;
        }
        int val[] = new int[n];
        for(int i = 0; i < n; i++){
            val[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][n + 1];
        for(int temp[] : dp){
            Arrays.fill(temp,-1);
        }
        System.out.println(solve(n - 1, weight,val,n,dp));
        System.out.println(solve_tabu(n , weight,val,n,dp));
    }


    //memoization;
    public static int solve(int ind , int weight[],int val[],int target,int dp[][]){
        if(ind == 0){
            return (target * val[0]);
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not_take = solve(ind - 1, weight,val,target,dp);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= target){
            take = val[ind] + solve(ind, weight, val,target - weight[ind],dp);
        }
        return dp[ind][target] = Math.max(take,not_take);
    }

    //Tabulation;
    public static int solve_tabu(int n , int weight[],int val[],int target,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp, 0);
        }
        for(int i = 0; i <= target; i++){
            dp[0][i] = (i * val[0]);
        }
        for(int ind = 1; ind < n; ind ++){
            for(int c = 0; c <= target; c++){
                int not_take = dp[ind - 1][c];
                int take = Integer.MIN_VALUE;
                if(weight[ind] <= c){
                    take = val[ind] + dp[ind][c - weight[ind]];
                }
                dp[ind][c] = Math.max(not_take,take);
            }
        }
        return dp[n - 1][target];
    }
}
