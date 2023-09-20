package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Cherry_pickup {
    //two staring points but variable ending points;
    //one starting point is (0 , 0) and another is (row - 1, col - 1);
    //but we will try to solve this problem starting from the same position (0 , 0) and (0 , 0)
    //this approach will also give the same answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int grid[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int dp[][][][] = new int[row + 1][col + 1][row + 1][col + 1];
        for(int row1[][][] : dp){
            for(int row2[][] : row1){
                for(int row3[] : row2){
                    Arrays.fill(row3,-1);
                }
            }
        }
        System.out.println(Math.max(0,solve(row,grid,0 , 0 , 0 , 0,dp)));

    }

    //here row and column are same;
    public static int solve(int row,int arr[][],int r1, int c1, int r2, int c2, int dp[][][][]){
        if(r1 >= row || c1 >= row || r2 >= row || c2 >= row || arr[r1][c1] == -1 || arr[r2][c2] == -1){
            return (int)Math.pow(-10,9);
        }
        if(dp[r1][c1][r2][c2] != -1){
            return dp[r1][c1][r2][c2];
        }
        if(r1 == row - 1 && c1 == row - 1){
            return arr[r1][c1];
        }
        if(r2 == row - 1 && c2 == row - 1){
            return arr[r2][c2];

        }
        int total = 0;
        if(r1 == r2 && c1 == c2){
            total = arr[r1][c1];
        }
        else{
            total = arr[r1][c1] + arr[r2][c2];
        }
        int first = solve(row, arr, r1 + 1, c1, r2 + 1,c2,dp);
        int second = solve(row, arr, r1 + 1,c1 , r2 , c2 + 1, dp);
        int third = solve(row ,arr, r1 , c1 + 1,r2 + 1, c2 ,dp);
        int fourth = solve(row, arr, r1, c1 + 1,r2 ,c2 + 1,dp);
        total += Math.max(Math.max(first,second) , Math.max(third, fourth));
        return dp[r1][c1][r2][c2] = total;
    }
}
