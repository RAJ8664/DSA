package Dynamic_programming;

import java.util.ArrayList;

public class Triangular_minimum_path_sum {
    public static void main(String[] args) {

    }


    //Recursive
    public static int solve(ArrayList<ArrayList<Integer>> arr, int row , int col){
        if(row == arr.size() - 1){
            return arr.get(row).get(col);
        }
        int down =arr.get(row).get(col) + solve(arr,row + 1,col);
        int diagonal = arr.get(row).get(col) + solve(arr, row + 1, col + 1);
        return (int)Math.min(down,diagonal);
    }

    //memoization
    public static int memoization(ArrayList<ArrayList<Integer>> arr,int row ,int col,int[][] dp){
        if(row == arr.size() - 1){
            return arr.get(row).get(col);
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int down = arr.get(row).get(col) + memoization(arr, row + 1, col, dp);
        int diagonal = arr.get(row).get(col) + memoization(arr,row + 1, col + 1,dp);
        return dp[row][col] = (int)Math.min(down,diagonal);
    }
}
