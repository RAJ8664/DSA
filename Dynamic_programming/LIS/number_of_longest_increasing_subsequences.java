package Dynamic_programming.LIS;

import java.util.Arrays;
import java.util.Scanner;

public class number_of_longest_increasing_subsequences {
    //Read the problem statement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = solve(arr);
        System.out.println(ans);
    }


    public static int solve(int arr[]){
        int n = arr.length;
        int dp[] = new int[n + 1];
        int count[] = new int[n + 1];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(1 + dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }
                    else if(1 + dp[j] == dp[i]){
                        count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                ans += count[i];
            }
        }
        return ans;
    }
}
