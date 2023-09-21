package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class count_number_of_subset_whose_sum_equal_to_k {
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
            Arrays.fill(temp, -1);
        }
        System.out.println(solve_recursion(n - 1, arr, target));
        System.out.println(solve_tabu( arr, target,dp));
    }


    //recursion;
    public static int solve_recursion(int ind , int arr[],int target){
        if(target == 0){
            return 1;
        }
        if(ind == 0){
            if(arr[0] == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        int not_take = solve_recursion(ind - 1, arr, target);
        int take = 0;
        if(arr[ind] <= target){
            take = solve_recursion(ind - 1, arr, target - arr[ind]);
        }
        return (take + not_take);
        //TC = O (2 ^ n) --> exponential;
        //SC = O(n);
    }

    //memoization;
    public static int solve_memo(int ind , int arr[],int target, int dp[][]){
        if(target == 0){
            return 1;
        }
        if(ind == 0){
            if(arr[0] == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not_take = solve_memo(ind - 1, arr, target, dp);
        int take = 0;
        if(arr[ind] <= target) {
            take = solve_memo(ind - 1, arr, target - arr[ind] , dp);
        }
        return dp[ind][target] = (take + not_take);
        //TC = O(n * target);
        //SC = O(n * target) + O(n);
    }

    //Tabulation;
    public static int solve_tabu(int arr[],int target,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        for(int ind = 1; ind < arr.length; ind++){
            for(int k = 1; k <= target; k++){
                int not_take = dp[ind - 1][k];
                int take = 0;
                if(arr[ind] <= k){
                    take = dp[ind - 1][k - arr[ind]];
                }
                dp[ind][k] = (not_take + take);
            }
        }
        return dp[arr.length - 1][target];
        //TC = O(n * k);
        //SC = O(n * k);
    }

}
