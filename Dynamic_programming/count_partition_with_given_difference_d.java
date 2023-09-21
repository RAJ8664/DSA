package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class count_partition_with_given_difference_d {
    //The base cases in all the approaches are different because there are zeroes in the
    //given input array so we need to put those base condition;
    //you can put this same base condition to all the previous problems;
    //that will also work fine for those problems;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int arr[] = new int[n];
        int total = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        if((total - d) < 0){
            System.out.println(0);
        }
        if((total - d) % 2 == 1){
            System.out.println(0);
        }
        else{
            int target = (total - d) / 2;
            int dp[][] = new int[n + 1][target + 1];
            System.out.println(solve_tabu(arr, target,dp));
        }

    }

    //To find s1 - s2 = d;
    //we know total = s1 + s2;
    //-- > s1 = total - s2;
    //-- > in first eqn --> total - s2 - s2 = d;
    //--> total - d = 2s2;
    //-->s2 = total -d / 2;
    //The final answer is count the number of subst having sum s2;


    //recursion;
    public static int solve(int ind , int arr[],int target){
        //following this case because array contains zeroes;
        if(ind == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            if(target == 0 || arr[0] == target){
                return 1;
            }
            return 0;
        }
        int not_take = solve(ind - 1, arr, target);
        int take = 0;
        if(arr[ind] <= target){
            take = solve(ind - 1, arr, target - arr[ind]);
        }
        return take + not_take;
        //TC = O(2 ^ n) --> exponential
        //SC = O(n);
    }


    //memoization;
    public static int solve_memo(int ind , int arr[],int target,int dp[][]){
        if(ind == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            if(target == 0 || arr[0] == target){
                return 1;
            }
            return 0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not_take = solve_memo(ind - 1, arr, target, dp);
        int take = 0;
        if(arr[ind] <= target){
            take = solve_memo(ind - 1, arr, target - arr[ind],dp);
        }
        return dp[ind][target] = (take + not_take);
        //TC = O(n * target);
        //SC = O(n * target) + O(n);

    }

    //Tabulation;
    public static int solve_tabu(int arr[],int target ,int dp[][]){
        for(int temp[] : dp){
            Arrays.fill(temp , 0);
        }
        if(arr[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }
        if(arr[0] != 0 && arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        for(int ind = 1; ind < arr.length; ind++) {
            for (int k = 0; k <= target; k++) {
                int not_take = dp[ind - 1][k];
                int take = 0;
                if (arr[ind] <= k) {
                    take = dp[ind - 1][k - arr[ind]];
                }
                dp[ind][k] = (take + not_take);
            }
        }
        return dp[arr.length - 1][target];
        //TC = O(n * target);
        //SC = O(n * target);
    }
}
