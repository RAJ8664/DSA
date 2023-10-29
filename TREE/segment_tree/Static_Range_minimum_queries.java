package segment_tree;

/*
* Given an array of n integers, your task is to process q queries of the form:
* what is the minimum value in range [a,b]?
*/

import java.util.Scanner;

public class Static_Range_minimum_queries {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int seg[] = new int[4 * n + 10];
        build(arr, seg,0,0,n - 1);

        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            --l;
            --r;
            System.out.println(query(arr,seg,0,0,n - 1, l ,r));
        }
    }

    public static int query(int arr[],int seg[],int ind,int low ,int high, int l , int r){
        //completely lies case;
        if(low >= l && high <= r){
            return seg[ind];
        }

        //not lies case
        if(high < l || low > r){
            //return something that is exaclty opposite of our result;
            //here we are computing min so we will return INT_MAX;
            //so that this case will not be considered;
            return Integer.MAX_VALUE;
        }

        //partial overlap;
        //we need to call both of them;
        int mid = low + (high - low) / 2;
        int left = query(arr, seg,2 * ind + 1, low,mid,l,r);
        int right = query(arr,seg,2 * ind + 2, mid + 1, high , l ,r);
        return Math.min(left,right);
    }
   public static void build(int arr[],int seg[], int ind , int low, int high){
        if(low == high){
            seg[ind] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(arr, seg, 2 * ind + 1, low, mid);
        build(arr,seg,2 * ind + 2 , mid + 1, high);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
   }
}
