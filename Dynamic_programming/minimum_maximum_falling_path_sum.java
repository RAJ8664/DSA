package Dynamic_programming;
import java.util.Arrays;
import java.util.Scanner;

public class minimum_maximum_falling_path_sum {
    public static void main(String[] args) {
        //variable starting point as well as variable ending point;
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(get_max_tabu(arr,row, col));
    }

    //Tabulation;
    public static int get_max_tabu(int arr[][],int row, int col){
        int dp[][] = new int[row + 1][col + 1];
        //base case i = 0;
        for(int j = 0; j < col; j++){
            dp[0][j] = arr[0][j];
        }
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                int up = arr[i][j];
                if(i - 1 >= 0){
                    up += dp[i - 1][j];
                }
                else{
                    up += (int)Math.pow(-10,9);
                }
                int left_diagonal = arr[i][j];
                if(j - 1 >= 0 && i - 1 >= 0){
                    left_diagonal += dp[i - 1][j - 1];
                }
                else{
                    left_diagonal += (int)Math.pow(-10,9);
                }
                int right_diagonal = arr[i][j];
                if(i - 1 >= 0 && j + 1 < col){
                    right_diagonal += dp[i - 1][j + 1];
                }
                else{
                    right_diagonal += (int)Math.pow(-10,9);
                }
                dp[i][j] = Math.max(up,Math.max(right_diagonal,left_diagonal));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < col; j++){
            max = Math.max(max,dp[row - 1][j]);
        }
        return max;
    }

    //memoization;
    public static int first_part(int arr[][],int i ,int j , int total_col, int dp[][]){
        if(j < 0 || j >= total_col){
            //return some value the would not be considered in our answer;
            //if it is asked to find the maximum return min or else return max;
            //over here i am finding maximum so i will return some min value;
            return (int)Math.pow(-10, 9);
        }
        if(i == 0){
            return arr[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = arr[i][j] + first_part(arr, i - 1, j , total_col, dp);
        int left_diagonal = arr[i][j] + first_part(arr, i - 1, j - 1, total_col, dp);
        int right_diagonal = arr[i][j] + first_part(arr, i - 1, j + 1, total_col, dp);
        return dp[i][j] = Math.max(up, Math.max(left_diagonal, right_diagonal));
    }

    public static int get_max(int arr[][]){
        int row = arr.length;
        int col = arr[0].length;
        int dp[][] = new int[row + 1][col + 1];
        for(int temp[] : dp){
            Arrays.fill(temp, -1);
        }
        int max = Integer.MIN_VALUE;
        for(int k = 0; k  < col; k++){
            int current = first_part(arr,row - 1,k,col,dp);
            max = Math.max(current,max);
        }
        return max;
    }
}
