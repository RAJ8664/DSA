package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

//given the matrix of m * n and you need to count the total unique path
//from (0, 0) to (n - 1, m - 1) given that you are only allowed to move
//either right or down
public class Total_unique_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] dp = new int[row + 1][col + 1];
        for(int[] raj : dp){
            Arrays.fill(raj,-1);
        }
        //starting from the destination;
        System.out.println(solve(row - 1, col - 1,dp));

    }

    //recursive solution
    public static int recursive_solution(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        //I am starting from the destination
        //so the condition become up  and left instead of right and down
        int up = recursive_solution(row - 1, col);
        //same here
        int left = recursive_solution(row, col - 1);
        return up + left;
        //TC --> O(2 ^ n * m);
        //SC --> O(m + n);
    }


    //DP solution
    //memoization
    public static int solve(int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col <  0){
            return 0;
        }
        if(dp[row][col] != -1 ){
            return dp[row][col];
        }
        return dp[row][col] = solve(row - 1, col,dp) + solve(row, col - 1, dp);
    }

    //Tabulation;
    public static solve1(int row, int col){
        dp[0][0] = 1;
        for(int i = 1; i < row; i++){
            for(int  j = 1; j < col; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    } 
}
