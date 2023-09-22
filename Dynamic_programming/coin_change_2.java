package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class coin_change_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][target + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve_Tabu(n,target,arr, dp));
    }


    //recursion;
    public static int solve(int ind , int arr[],int target){
        if(target == 0){
            return 1;
        }
        if(ind == 0){
            if(target % arr[0] == 0){
                return 1;
            }
            return 0;
        }
        int not_take = solve(ind - 1, arr, target);
        int take = 0;
        if(arr[ind] <= target){
            take = solve(ind, arr, target - arr[ind]);
        }
        return (take + not_take);
    }


    //memoization;
    public static int solve_memo(int ind , int arr[],int target,int dp[][]){
        if(target == 0){
            return 1;
        }
        if(ind == 0){
            if(target % arr[0] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not_take = solve_memo(ind - 1, arr, target, dp);
        int take = 0;
        if(arr[ind] <= target){
            take = solve_memo(ind, arr, target - arr[ind], dp);
        }
        return dp[ind][target] = (take + not_take);
    }

    //Tabulation;
    public static int solve_Tabu(int n , int target,int arr[],int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp,0);
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int t = 0; t <= target; t++){
            if(t % arr[0] == 0){
                dp[0][t] = 1;
            }
            else{
                dp[0][t] = 0;
            }
        }
        for(int ind = 1; ind < n; ind++){
            for(int c = 0; c <= target; c++){
                int not_take = dp[ind - 1][c];
                int take = 0;
                if(arr[ind] <= c){
                    take = dp[ind][c - arr[ind]];
                }
                dp[ind][c] = (take + not_take);
            }
        }
        return dp[n - 1][target];
    }
}
