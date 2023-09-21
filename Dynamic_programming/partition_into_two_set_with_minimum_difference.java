package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class partition_into_two_set_with_minimum_difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int dp[][] = new int[n + 1][sum + 1];
        for(int temp[] : dp){
            Arrays.fill(temp,-1);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++){
            if(solve(n - 1, arr, i, dp) == 1){
                min = Math.min(min, Math.abs(i - (sum - i)));
            }
        }
        System.out.println(min);
    }


    //bruteforce;
    //may not work for negative Integers;
    //check the input;
    public static int solve(int ind , int arr[],int target, int dp[][]){
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
        int not_take = solve(ind - 1, arr, target, dp);
        int take = 0;
        if(arr[ind] <= target){
            take = solve(ind - 1, arr, target - arr[ind],dp);

        }
        return dp[ind][target] = (take | not_take);
    }
}
