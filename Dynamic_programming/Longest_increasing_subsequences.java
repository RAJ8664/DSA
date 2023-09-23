package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_increasing_subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][n + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }
        System.out.println(solve(0,arr,-1,dp));
    }

    //recursion;
    public static int solve_recursion(int ind, int arr[],int prev){
        if(ind >= arr.length){
            return 0;
        }
        int not_take = solve_recursion(ind + 1, arr, prev);
        int take = 0;
        if(prev == -1 || arr[ind] > arr[prev]){
            take = 1 + solve_recursion(ind + 1, arr, ind);
        }
        return Math.max(take , not_take);
    }


    //memoization;
    public static int solve(int ind ,int arr[],int prev, int dp[][]){
        if(ind >= arr.length){
            return 0;
        }
        if(dp[ind][prev + 1] != -1){
            return dp[ind][prev + 1];
        }
        int not_take = solve(ind + 1, arr, prev, dp);
        int take = 0;
        if(prev == -1 || arr[ind] > arr[prev]){
            take = 1 + solve(ind + 1 ,arr, ind, dp);
        }
        return dp[ind][prev + 1] = Math.max(take, not_take);
    }

    //best optimal approach;
    public static int optimal_approach(int arr[]) {
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        int length = 1;
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < dp[0]) {
                dp[0] = arr[i];
            } else if (arr[i] > dp[length - 1]) {
                dp[length] = arr[i];
                length++;
            } else {
                int index = Arrays.binarySearch(dp, 0, length, arr[i]);
                if (index < 0) {
                    index = -index - 1;
                }
                dp[index] = arr[i];
            }
        }
        return length;
    }
}
