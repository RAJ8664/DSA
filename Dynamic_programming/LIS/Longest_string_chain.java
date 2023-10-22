package Dynamic_programming.LIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Longest_string_chain {
    //part of lis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for(int i = 0; i < n; i++){
            String s = sc.next();
            arr[i] = s;
        }
        int dp[] = new int[n + 1];
        int ans = solve(arr,n  , dp);
        System.out.println(ans);
    }

    public static boolean compare(String s, String t){
        if(s.length() != t.length() + 1) return false;
        int i = 0;
        int j = 0;
        while(i < s.length()){
           if(j < t.length() && s.charAt(i) == t.charAt(j)){
               i++;
               j++;
           }
           else{
               i++;
           }

        }
        if(i == s.length() && j == t.length()) return true;
        return false;
    }

    public static int solve(String words[],int n , int dp[]){
        Arrays.fill(dp, 1);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        int max = 1;
        for(int ind = 0; ind < n; ind++){
            for(int prev = 0; prev < ind; prev++){
                if(compare(words[ind],words[prev])){
                    dp[ind] = Math.max(dp[ind],1 + dp[prev]);
                }
            }
            max = Math.max(max,dp[ind]);
        }
        return max;
    }
}
