package segment_tree;

import java.util.Scanner;

/*
* Given an array of n integers, your task is to process q queries of the form:
* what is the sum of values in range [a,b]?
* */
public class Static_Range_sum_queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long arr[] = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        long pre[] = new long[n];
        for(int i = 0; i < n; i++){
            sum += arr[i];
            pre[i] = sum;
        }

        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            //to make zero based indexing;
            --l;
            --r;
            if(l == 0) System.out.println(pre[r]);
            else System.out.println(pre[r] - pre[l - 1]);
        }

    }


}
