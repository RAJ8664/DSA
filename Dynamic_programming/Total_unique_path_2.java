package Dynamic_programming;
import java.util.Arrays;
import java.util.Scanner;

public class Total_unique_path_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int grid[][] = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[row + 1][col + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , -1);
        }

        System.out.println(solve(grid,row, col));
        System.out.println(solve_memo(row - 1, col - 1, dp,grid));
    }

    //recursive;
    public static int solve(int arr[][],int row, int col){
        if(row < 0 || col < 0){
            return 0;
        }
        //1 here states there is bomb in that row and column;
        if(arr[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        int up = solve(arr, row - 1, col);
        int left = solve(arr, row, col - 1);
        return up + left;
    }

    //memoization;
    public static int solve_memo(int row, int col , int dp[][],int arr[][]){
        if(row < 0 || col < 0){
            return 0;
        }
        if(arr[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = solve_memo(row - 1, col, dp, arr);
        int left = solve_memo(row, col - 1, dp, arr);
        return dp[row][col] = up + left;
    }

    //Tabulation;
    public static int solve_tabu(int row, int col, int arr[][],int dp[][]){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                //up;
                int up = 0;
                if(i > 0){
                  up = dp[i - 1][j];
                }
                //left;
                int left = 0;
                if(j > 0){
                    left =  dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[row - 1][col - 1];
    }
}
