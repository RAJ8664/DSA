package Dynamic_programming.DP_ON_STRINGS;

import java.util.Arrays;
import java.util.Scanner;

public class minimum_length_and_string_of_supersubsequence {
    public static void main(String[] args) {
        //to find the minimum length the answer is ( n + m ) - lcs of (string first , string second);
        //where n = length of first string and m = length of second string;
        //lcs(first,second) = length of longest common subsequence of first and second string;
        Scanner sc =  new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solve(a,b));
    }


    //printing of shortest supersubsequence of string;
    public static String solve(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        //constructing dp table for the longest common subsequences;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j  - 1)){
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j  - 1]){
                sb.append(str1.charAt(i - 1));
                i--;
            }
            else{
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while(i > 0){
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j - 1));
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}
