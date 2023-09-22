package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class unbound_knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int val[] = new int[n];
        for(int i = 0; i <n; i++){
            val[i] = sc.nextInt();
        }
        int weight[] = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][capacity + 1];
        for(int temp[] : dp){
            Arrays.fill(temp,-1);
        }
        System.out.println(solve_tabu(n ,weight,val,capacity,dp));
        System.out.println(solve_recursion(n - 1, weight,val,capacity));
    }


    //recursion;
    public static int solve_recursion(int ind , int weight[],int val[],int capacity){
        if(ind == 0){
            if(weight[0] <= capacity){
                return val[0] * ((int)(capacity / weight[0]));
            }
            else{
                return 0;
            }
        }
        int not_take = solve_recursion(ind - 1, weight,val,capacity);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= capacity){
            take = val[ind] + solve_recursion(ind,weight,val,capacity - weight[ind]);
        }
        return Math.max(take,not_take);
    }

    //memoization;
    public static int solve_memo(int ind , int weight[],int val[],int capacity, int dp[][]){
        if(ind == 0){
            if(weight[0] <= capacity){
                return val[0] * (capacity / weight[0]);
            }
            return 0;
        }

        if(dp[ind][capacity] != -1){
            return dp[ind][capacity];
        }
        int not_take = solve_memo(ind - 1, weight,val,capacity,dp);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= capacity){
            take = val[ind] + solve_memo(ind , weight,val,capacity - weight[ind],dp);
        }
        return dp[ind][capacity] = Math.max(take,not_take);
    }

    //Tabulation;
    public static int solve_tabu(int n ,int weight[],int val[],int capacity,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp,0);
        }
        //just see the code in the memoization and write the base cases;
        for(int c = 0; c <= capacity; c++){
            if(weight[0] <= c){
                dp[0][c] = val[0] * ((int)(c / weight[0]));
            }
            else{
                dp[0][c] = 0;
            }
        }
        for(int ind = 1; ind < n; ind ++){
            for(int w = 0; w <= capacity; w++){
                int not_take = dp[ind - 1][w];
                int take = Integer.MIN_VALUE;
                if(weight[ind] <= w){
                    take = val[ind] + dp[ind][w - weight[ind]];
                }
                dp[ind][w] = Math.max(take,not_take);
            }
        }
        return dp[n - 1][capacity];
    }
}
