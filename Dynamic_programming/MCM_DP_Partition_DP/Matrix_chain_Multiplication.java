package Dynamic_programming.MCM_DP_Partition_DP;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_chain_Multiplication {
    //Read the problem statement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int dp[][] = new int[n + 1][n + 1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        int ans = solve_recursive(arr, 1, n - 1);
        int ans1 = solve_memo(arr,1, n - 1, dp);
        int ans2 = solve_tabu(arr, n , dp);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }


    //Recursive solution;
    public static int solve_recursive(int arr[],int i, int j){
        if(i == j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + solve_recursive(arr,i, k) + solve_recursive(arr,k + 1, j);
            min = Math.min(min,steps);
        }
        return min;
    }


    //memoization solution;
    public static int solve_memo(int arr[],int i, int j ,int dp[][]){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + solve_memo(arr, i , k,dp) + solve_memo(arr, k + 1, j , dp);
            min = Math.min(min,steps);
        }
        return dp[i][j] = min;
    }


    //Tabulation solution;
    public static int solve_tabu(int arr[],int n, int dp[][]){
        for(int row[] :dp){
            Arrays.fill(row, 0);
        }
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int steps = arr[i - 1] * arr[j] * arr[k] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min,steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }
}
