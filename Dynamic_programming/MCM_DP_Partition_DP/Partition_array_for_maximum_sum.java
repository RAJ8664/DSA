package Dynamic_programming.MCM_DP_Partition_DP;

import java.util.Arrays;
import java.util.Scanner;

public class Partition_array_for_maximum_sum {
    //Read the problem statement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = solve_recursion(arr, 0 , n ,k);
        System.out.println(ans);

    }

    //recursive solution;
    public static int solve_recursion(int arr[],int i , int n , int k){
        if(i == n) return 0;
        int len = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n , k + i); j++){
            len++;
            maxi = Math.max(maxi ,arr[j]);
            sum = len * maxi + solve_recursion(arr, j + 1, n , k);
            mx = Math.max(mx,sum);
        }
        return mx;
    }

    //memoization solution;
    public static int solve_memo(int arr[],int i, int n , int k , int dp[]){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int len = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(n , k + i); j++){
            len++;
            maxi = Math.max(maxi , arr[j]);
            sum = len * maxi + solve_memo(arr, j + 1, n , k , dp);
            mx = Math.max(mx, sum);
        }
        return dp[i] = mx;
    }


    //Tabulation solution;
    public static int solve_tabu(int arr[],int n , int k){
        int dp[] = new int[n + 1];
        Arrays.fill(dp,0);
        for(int i = n - 1; i >= 0; i--){
            int len = 0;
            int sum = 0;
            int maxi = Integer.MIN_VALUE;
            int mx = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(n , k + i); j++){
                len++;
                maxi = Math.max(maxi , arr[j]);
                sum = len * maxi + dp[j + 1];
                mx = Math.max(mx, sum);
            }
            dp[i] = mx;
        }
        return dp[0];
    }
}
