package Dynamic_programming;
import java.util.Arrays;
import java.util.Scanner;
public class ninja_and_his_friends {
    //two starting points but variable ending points;
    //one starting points is (0 , 0) and another is (0 , col - 1);
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

        int dp[][][] = new int[row + 1][col + 1][col + 1];
        for(int row1[][] : dp){
            for(int row2[] : row1){
                Arrays.fill(row2, -1);
            }
        }
        System.out.println(solve(grid,0, 0, col - 1,dp));
    }

    //memoization;
    public static int solve(int arr[][],int i, int j1, int j2 , int dp[][][]){
        //if any one of them get outside of the matrix;
        if(j1 < 0 || j2 < 0 || j1 >= arr[0].length || j2 >= arr[0].length){
            //returning something that will never be included in our answer;
            return (int)Math.pow(-10,9);
        }
        // if they reach at the last row;
        //they may end up at same column , if so we only return one value;
        //else we return both the value;
        if(i == arr.length - 1){
            if(j1 == j2){
                return arr[i][j1];
            }
            else{
                return arr[i][j1] + arr[i][j2];
            }
        }
        //check if we have already calculated it;
        if(dp[i][j1][j2] != -1){
            return dp[i][j2][j2];
        }

        //going through all the paths possible;
        //observe clearly that there are 9 possible combos;
        //lets say one guy takes one position then another guy will have 3 decision to make;
        //so there will be 3 * 3 = 9 paths in total;
        //and we are going through every one of the path;
        int max = 0;
        for(int ci = -1; ci <= 1; ci++){
            for(int cj = -1; cj <= 1; cj++){
                int val = 0;
                if(j1 == j2){
                    val = arr[i][j1];
                }
                else{
                    val = arr[i][j1] + arr[i][j2];
                }
                val += solve(arr, i + 1, j1 + ci, j2 + cj,dp);
                max = Math.max(max, val);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
