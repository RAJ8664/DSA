package Dynamic_programming.MCM_DP_Partition_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Minimum_cost_to_cut_the_stick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stick_size = sc.nextInt();
        int stick[] = new int[n];
        for(int i = 0; i < n; i++){
            stick[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i <n ; i++){
            ans.add(stick[i]);
        }
        int dp[][] = new int[n + 2][n + 2];

        Arrays.sort(stick);
        int ans1 = solve_rucursive(0 , stick_size,stick,0, n - 1);
        int ans2 = solve(ans,stick_size,n,dp);
        System.out.println(ans1);
        System.out.println(ans2);

    }


    //recursive solution;
    public static int solve_rucursive(int start, int end, int arr[],int left , int right){
        if(left > right) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            int left_cost = solve_rucursive(start, arr[i],arr, left, i - 1);
            int right_cost = solve_rucursive(arr[i],end, arr, i + 1, right);
            int cost = end - start + left_cost + right_cost;
            min = Math.min(min, cost);
        }
        return min;
    }


    //memoization solution;
    public static int solve_memo(int start, int end, int arr[],int left, int right ,int dp[][]){
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            int left_cost = solve_memo(start, arr[i],arr,left, i - 1,dp);
            int right_cost = solve_memo(arr[i],end, arr, i + 1, right,dp);
            int cost = end - start + left_cost + right_cost;
            min = Math.min(min,cost);
        }
        return dp[left][right] = min;
    }

    //tabulation solution;
    public static int solve(ArrayList<Integer> arr,int stick_size, int n,int dp[][]){
        arr.add(0);
        arr.add(stick_size);
        Collections.sort(arr);
        for(int row[] : dp){
            Arrays.fill(row, 0);
        }
        for(int i = n ; i >= 1; i--){
            for(int j = 1 ; j <= n ; j++){
                if(i > j) continue;
                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    int cost = arr.get(j + 1) - arr.get(i - 1) + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min,cost);
                }
                dp[i][j] = min;
            }

        }
        return dp[1][n];
    }
}
