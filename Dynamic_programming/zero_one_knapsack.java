package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class zero_one_knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight[] = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
        }
        int val[] = new int[n];
        for(int i = 0; i < n; i++){
            val[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        int dp[][] = new int[n + 1][capacity + 1];
        for(int temp[] : dp){
            Arrays.fill(temp, -1);
        }
        System.out.println(solve_tabu(n, val,weight, capacity,dp));
    }



    //recursion;
    public static int solve(int ind , int val[],int weight[],int capacity){
        if(ind == 0){
            if(weight[ind] <= capacity){
                return val[ind];
            }
            return 0;
        }

        int not_take = 0 + solve(ind - 1, val, weight, capacity);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= capacity){
            take = val[ind] + solve(ind - 1, val ,weight, capacity - weight[ind]);
        }
        return Math.max(take, not_take);
        //TC = O(2 ^ n) --> exponential;
        //SC = (n);
    }

    //memoization;
    public static int solve_memo(int ind , int val[],int weight[],int capacity,int dp[][]){
        if(ind == 0){
            if(weight[ind] <= capacity){
                return val[ind];
            }
            return 0;
        }
        if(dp[ind][capacity] != -1){
            return dp[ind][capacity];
        }
        int not_take = solve_memo(ind - 1, val ,weight, capacity, dp);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= capacity){
            take = val[ind] + solve_memo(ind - 1, val,weight, capacity - weight[ind],dp);
        }
        return dp[ind][capacity] = Math.max(take,not_take);
        //TC = O(n * capacity);
        //SC = O(n * capacity) + O(n);
    }

    //Tabulation;
    public static int solve_tabu(int n,int val[],int weight[],int capacity,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp, 0);
        }
        for(int i = weight[0]; i <= capacity; i++){
            dp[0][i] = val[0];
        }
        for(int ind = 1; ind < n; ind++){
            for(int c = 0; c <= capacity; c++){
                int not_take = dp[ind - 1][c];
                int take = Integer.MIN_VALUE;
                if(weight[ind] <= c){
                    take = val[ind] + dp[ind - 1][c - weight[ind]];
                }
                dp[ind][c] = Math.max(take, not_take);
            }
        }
        return dp[n- 1][capacity];
        //TC = O(n * capacity);
        //TC = O(n * capacity);
    }
}
