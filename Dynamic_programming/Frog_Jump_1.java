package Dynamic_programming;
import java.util.Arrays;
import java.util.Scanner;
public class Frog_Jump_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp,-1);
            System.out.println(solve1(arr,arr.length));
        }
    }

    
    //memoization;
    public static int solve(int[] arr,int ind,int[] dp){
        if(ind == 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int two = Integer.MAX_VALUE;
        int one = solve(arr,ind - 1, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        if(ind > 1){
            two = solve(arr,ind - 2, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        }
        return dp[ind] = Math.min(one,two);
        //TC = O(n);
        //SC = O(n) + O(n);
    }

    //tabulation
    public static int solve1(int[] arr,int n){
        int[] dp  = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < n ; i++){
            int fs = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(ss,fs);
        }
        return dp[n -1];
    }
    //TC = O(n);
    //sc = O(n);
}
