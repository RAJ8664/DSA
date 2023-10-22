package Dynamic_programming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Longest_increasing_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 5][n + 10];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve_binary_search(arr);
        System.out.println(ans);
    }

    //recursive solution;
    public static int solve_recursion(int arr[],int ind , int prev){
        if(ind >= arr.length) return 0;

        int take = Integer.MIN_VALUE;
        if(prev == -1 || arr[ind] > arr[prev] ){
            take = 1 + solve_recursion(arr,ind + 1, ind);
        }
        int not_take = solve_recursion(arr,ind + 1, prev);
        return Math.max(not_take,take);
    }


    //memoization solution;
    public static int solve_memo(int arr[],int ind, int prev,int dp[][]){
        if(ind >= arr.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        //take;
        int take = 0;
        if(prev == -1 || arr[ind] > arr[prev]){
            take = 1 + solve_memo(arr,ind + 1, ind ,dp);
        }
        int not_take = 0 + solve_memo(arr,ind + 1, prev, dp);
        return dp[ind][prev + 1] = Math.max(take,not_take);
    }

    //tabulation solution;
    public static int solve_tabu(int arr[],int n , int dp[][]){
        for(int row[] : dp){
            Arrays.fill(row, 0);
        }
        for(int ind = n - 1; ind >= 0; ind--){
            for(int prev = ind - 1; prev >= -1; prev--){
                int take = 0;
                if(prev == -1 || arr[ind] > arr[prev]){
                    take = 1 + dp[ind + 1][ind + 1];

                }
                int not_take = dp[ind + 1][prev + 1];
                dp[ind][prev + 1] = Math.max(not_take,take);
            }
        }
        return dp[0][0];
    }

    //space optimization;
    public static int solve_optimal(int arr[],int n , int dp[]){
        Arrays.fill(dp,1);
        int max = 0;
        for(int ind = 0; ind < n; ind ++){
            for(int prev = 0; prev < ind; prev++){
                if(arr[prev] < arr[ind]){
                    dp[ind] = Math.max(dp[ind],1 + dp[prev]);
                }
            }
            max = Math.max(max,dp[ind]);
        }
        return max;
    }

    //time optimization using binary search;
    public static int solve_binary_search(int arr[]){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > ans.get(ans.size() - 1)){
                ans.add(arr[i]);
            }
            else{
                int ind = Collections.binarySearch(ans,arr[i]);
                if(ind < 0) ind =  - ind - 1;
                ans.set(ind,arr[i]);
            }
        }
        return ans.size();
    }
}
