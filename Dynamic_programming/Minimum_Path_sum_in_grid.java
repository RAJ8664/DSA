package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Path_sum_in_grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] grid = new int[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[row + 1][col + 1];
            for(int[] raj : dp){
                Arrays.fill(raj, -1);
            }
            System.out.println(solve(grid,row - 1, col - 1,dp));
        }
    }
    //Recursive
    public static int recursive(int arr[][] ,int row, int col){
        if(row < 0 || col < 0){
            //some bigger value , so that this one is not included in our answer;
            return (int)Math.pow(10,9);
        }
        if(row == 0 && col == 0){
            return arr[row][col];
        }
        int up = arr[row][col] + recursive(arr, row - 1, col);
        int left = arr[row][col] + recursive(arr, row, col - 1);
        return Math.min(up, left);
    }

    //memoization
    public static int solve(int[][] grid,int row,int col,int[][] dp){
        if(row == 0 && col == 0){
            return grid[0][0];
        }
        if(row < 0 || col < 0){
            return (int)Math.pow(10,9);
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = grid[row][col] + solve(grid,row - 1,col,dp);
        int left = grid[row][col] + solve(grid,row, col - 1,dp);
        return dp[row][col] = Math.min(up,left);
    }

    //Tabulation
    public static int solve1(int[][] arr,int row ,int col ,int[][] dp){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = arr[i][j];
                }
                else{
                    int up = arr[i][j];
                    if(i > 0){
                        up += dp[i - 1][j];
                    }
                    else{
                        //take some bigger value such that this  will not  be in included in answer;
                        up += Math.pow(10,9);
                    }
                    int left = arr[i][j];
                    if(j > 0){
                        left += dp[i][j - 1];
                    }
                    else{
                        left += Math.pow(10,9);
                    }
                    dp[i][j] = Math.min(left,up);
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
