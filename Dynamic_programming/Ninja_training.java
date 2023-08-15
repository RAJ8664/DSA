package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Ninja_training {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[][] points = new int[n][3];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < 3; j ++){
                    points[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n + 1][4];
            for(int[] row : dp){
                Arrays.fill(row, - 1);
            }
            System.out.println(solve(points,n - 1,3,dp));
        }
    }



    //memoization
    public static int solve(int[][] points , int day , int last , int[][] dp){
        if(day == 0){
            int max = 0;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    max = Math.max(max,points[0][i]);
                }
            }
            return dp[day][last] = max;
        }
        if(dp[day][last] != -1){
            return dp[day][last];
        }
        int max = 0;
        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + solve(points,day - 1,i,dp);
                max = Math.max(max,point);
            }
        }
        return dp[day][last] = max;
    }
}
