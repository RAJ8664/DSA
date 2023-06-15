public class Best_Time_to_buy_and_Sell_Stock {
    /*
    *
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.

       You want to maximize your profit by choosing a single day to buy one stock and choosing
        a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction.
         If you cannot achieve any profit, return 0.*/
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(bruteforce(arr));
        System.out.println(optimal_approach(arr));
    }

    public static int bruteforce(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, arr[j] - arr[i]);
            }
        }
        return max;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int optimal_approach(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max_profit = Math.max(max_profit, arr[i] - min);
        }
        return max_profit;
        //TC=O(n);
        //SC=O(1);
    }
}