package Sliding_window;

import java.util.Scanner;

public class smallest_subarray_with_sum_gretater_than_x {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]  = sc.nextInt();
        }
        int ans = solve(arr,x);
    }
    public static int solve(int arr[],int x){
        int n = arr.length;
        int sum = 0;
        int start = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            while(start + 1 < n && sum <= x){
                start++;
                sum = sum + arr[start];
            }
            if(sum > x) min = Math.min(min, start - i + 1);
            sum = sum - arr[i];
        }
        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }
}
