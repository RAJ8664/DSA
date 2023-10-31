package Sliding_window;

import java.util.Scanner;

public class maximum_consecutive_ones3 {
    //read the problem statement at leetcode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = solve(arr, k);
        System.out.println(ans);
    }

    public static int solve(int arr[],int k){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int start = -1;
        for(int i = 0; i < n; i++){
            while(start + 1 < n && k > 0 || start + 1 < n && arr[start + 1] == 1){
                start++;
                if(arr[start] == 0) k--;
            }
            max = Math.max(max, start - i + 1);
            if(arr[i] == 0) k++;
        }
        return max;
    }
}
