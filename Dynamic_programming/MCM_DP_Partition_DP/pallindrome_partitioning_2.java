package Dynamic_programming.MCM_DP_Partition_DP;
import java.util.Arrays;
import java.util.Scanner;

public class pallindrome_partitioning_2 {
    //Read the problem satement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = solve_recursive(s, 0, s.length());
        System.out.println(solve_tabu(s,s.length()) - 1);
        System.out.println(ans - 1);

    }

    public static boolean ispallindrome(String s){
        int n = s.length();
        for(int i = 0; i < n / 2; i ++){
            if(s.charAt(i) != s.charAt(n - 1- i)) return  false;
        }
        return true;
    }

    //recursive soulution;
    public static int solve_recursive(String s, int i, int n){
        if(i == s.length()) return 0;
        int min = Integer.MAX_VALUE;
        String temp = "";
        for(int j = i; j < n; j++){
            temp = temp + s.charAt(j);
            if(ispallindrome(temp)){
                int cost = 1 + solve_recursive(s, j + 1, n);
                min = Math.min(min,cost);
            }
        }
        return min;
    }

    //memoization solution;
    public static int solve_memo(String s, int i , int n , int dp[]){
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];

        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            temp = temp + s.charAt(j);
            if(ispallindrome(temp)) {
                int cost = 1 + solve_memo(s, j + 1, n, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    //Tabulation solution;
    public static int solve_tabu(String s, int n){
        int dp[] = new int[n + 1];
        Arrays.fill(dp,0);

        for(int i = n - 1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            String temp = "";
            for(int j = i; j < n; j++){
                temp = temp + s.charAt(j);
                if(ispallindrome(temp)){
                    int cost = 1 + dp[j + 1];
                    min = Math.min(min,cost);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}
