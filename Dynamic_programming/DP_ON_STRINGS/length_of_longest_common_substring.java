package Dynamic_programming.DP_ON_STRINGS;

import java.util.Arrays;

public class length_of_longest_common_substring {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 2,1};
        int arr2[] = {3,2,1,4,7};
        int ind1 = arr1.length;
        int ind2 = arr2.length;
        int dp[][] = new int[ind1 + 1][ind2 + 1];
        System.out.println(solve(ind1, ind2, arr1, arr2,dp));

    }



    public static int solve(int ind1, int ind2, int arr1[],int arr2[],int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        int ans = 0;
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static int solve_tabu(int ind1, int ind2, String s, String t, int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }

        int ans = 0;
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
