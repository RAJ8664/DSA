package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Subset_sum_equal_to_target {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][target + 1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        if(solve(n - 1, arr, target , dp) == 1){
            System.out.println("True");
        }
        else{
            System.out.println("False;");
        }
    }

    //recursive approach;
    public static boolean solve(int ind , int arr[],int target){
        if(target == 0){
            return true;
        }
        if(ind == 0){
            return arr[0] == target;
        }
        boolean not_take = solve(ind - 1, arr, target);
        boolean take = false;
        if(arr[ind] <= target){
            take = solve(ind - 1, arr, target - arr[ind]);
        }
        return (take | not_take);
        //TC = O(2 ^ n) (exponential);
        //SC = O(n);
    }


    //memoization;
    public static int solve(int ind , int arr[], int target, int dp[][]){
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
        int not_take = solve(ind - 1, arr, target , dp);
        int take = 0;
        if(arr[ind] <= target){
            take = solve(ind - 1, arr,target - arr[ind] ,dp);
        }
        return dp[ind][target] = (not_take | take);
        //TC = O(n * target);
        //SC = O(n * target)-->dp + O(n)-->stack space;

    }
    //Tabulation;
    public static boolean solve_tabu(int arr[],int target,boolean dp[][]){
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }
        for(int ind = 1; ind < arr.length; ind++){
            for(int k = 1; k <= target; k++){
                boolean not_take = dp[ind - 1][k];
                boolean take = false;
                if(arr[ind] <= k){
                    take = dp[ind - 1][k - arr[ind]];
                }
                dp[ind][k] = (not_take ||  take);
            }
        }
        return dp[arr.length - 1][target];
        //TC = O(n * k);
        //SC = O(n * k);
    }
}
