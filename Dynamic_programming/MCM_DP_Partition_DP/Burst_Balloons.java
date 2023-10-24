package Dynamic_programming.MCM_DP_Partition_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Burst_Balloons {
    //Read the problem statement;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

    }

    //Recursive_solution;
    public static int solve_recursive(ArrayList<Integer> ans ,int i , int j){
        if(i > j) return 0;

        int max = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int coins = ans.get(i - 1) * ans.get(ind) * ans.get(j + 1) + solve_recursive(ans,i,ind - 1) + solve_recursive(ans,ind + 1, j);
            max = Math.max(max, coins);
        }
        return max;
    }

    //memoization solution;
    public static int solve_memo(ArrayList<Integer> ans,int i, int j , int dp[][]){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int coins = ans.get(i - 1) * ans.get(ind) * ans.get(j + 1) + solve_memo(ans,i, ind - 1,dp) + solve_memo(ans,ind + 1 , j , dp);
            max = Math.max(max, coins);
        }
        return dp[i][j] = max;
    }

    //Tabulation solution;
    public static int solve(int arr[],int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 0; i < n; i++){
            ans.add(arr[i]);
        }
        ans.add(1);
        int dp[][] = new int[n + 2][n + 2];
        for(int row[] : dp){
            Arrays.fill(row, 0);
        }

        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) continue;
                int max = Integer.MIN_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int coins = ans.get(i - 1) * ans.get(ind) * ans.get(j + 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
