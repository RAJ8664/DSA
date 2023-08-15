package Dynamic_programming;


//same as the maximum non adjacent sum but here the first ans last house is connected

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class House_robber_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                int x = sc.nextInt();
                arr.add(x);
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, - 1);
            ArrayList<Integer> ans = new ArrayList<>();
            ArrayList<Integer> ans1 = new ArrayList<>();
            for(int i = 0; i < n ;i++){
                if(i != 0){
                    ans.add(arr.get(i));
                }
                if(i != n - 1){
                    ans1.add(arr.get(i));
                }
            }
            if(n == 1){
                System.out.println(arr.get(0));
            }
            else{
                int temp = solve(ans,ans.size() - 1, dp);
                int temp1= solve(ans1,ans1.size() - 1, dp);
                System.out.println(Math.max(temp,temp1));
            }
        }

    }


    //memoization
    public static int solve(ArrayList<Integer> arr,int n, int[] dp){
        if(n == 0){
            return arr.get(0);
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = arr.get(n) + solve(arr, n - 2, dp);
        int not_pick = solve(arr, n - 1, dp);
        return dp[n] = Math.max(pick,not_pick);
    }


    //tabulation
    public static int solve1(ArrayList<Integer> arr,int n ,int[] dp){
        dp[0] = arr.get(0);
        for(int i = 1; i < n; i++){
            int pick = arr.get(i);
            if(i > 1){
                pick += dp[i - 2];
            }
            int not_pick = dp[i - 1];
            dp[i] = Math.max(pick,not_pick);
        }
        return dp[n - 1];
    }
}
