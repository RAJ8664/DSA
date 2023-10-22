package Dynamic_programming.LIS;

import java.util.Arrays;
import java.util.Scanner;

public class Longes_bitonic_subsequence {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
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
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2,1);
        for(int ind = 0; ind < n; ind++){
            for(int prev = 0; prev < ind; prev++){
                if(arr[ind] > arr[prev] ){
                    dp1[ind] = Math.max(dp1[ind],1 + dp1[prev]);
                }
            }

        }
        for(int ind = n - 1; ind >= 0; ind--){
            for(int prev = n - 1; prev > ind ; prev--){
                if(arr[ind] > arr[prev]){
                    dp2[ind] = Math.max(dp2[ind],1 + dp2[prev]);
                }
            }
        }
        int maxi = -1;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}
