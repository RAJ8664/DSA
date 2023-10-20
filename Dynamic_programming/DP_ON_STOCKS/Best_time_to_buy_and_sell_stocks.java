package Dynamic_programming.DP_ON_STOCKS;

import java.util.Scanner;

public class Best_time_to_buy_and_sell_stocks {
    //Read the problem statement first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans=  solve(arr);
        System.out.println(ans);
    }


    public static int solve(int arr[]){
        int n = arr.length;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min,arr[i]);
            profit = Math.max(profit, arr[i] - min);
        }
        return profit;
    }
}
