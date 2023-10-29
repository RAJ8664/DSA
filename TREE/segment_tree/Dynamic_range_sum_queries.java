package segment_tree;


import java.util.Scanner;

/* Given an array of n integers, your task is to process q queries of the following types:
   update the value at position k to u
   what is the sum of values in range [a,b]?
* */
public class Dynamic_range_sum_queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int seg[] = new int[4 * n + 2];
        build(arr,seg,0,0,n - 1);
        for(int i = 0; i < q; i++){
            int type = sc.nextInt();
            if(type == 1){
                int index = sc.nextInt();
                int val = sc.nextInt();
                index--;
                update(arr,seg,0,0,n - 1, index,val);
            }
            else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                --l;
                --r;
                System.out.println(query(arr,seg,0,0,n - 1, l, r));
            }
        }
    }

    public static void update(int arr[],int seg[],int ind, int low, int high,int index,int val){
        if(low == high){
            seg[ind] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        //left part;
        if(index <= mid) update(arr,seg,2 * ind + 1, low, mid, index, val);
        //right part;
        else update(arr, seg,2 * ind + 2, mid + 1, high ,index, val);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];

    }
    public static int query(int arr[],int seg[],int ind, int low, int high , int l, int r){
        if(low >= l && high <= r){
            return seg[ind];
        }
        if(low > r || high < l){
            return 0;
        }
        int mid = low + (high - low) / 2;
        int left = query(arr, seg, 2 * ind + 1, low , mid, l ,r);
        int right = query(arr, seg,2 * ind + 2, mid + 1, high , l ,r);
        return left + right;
    }

    public static void build(int arr[],int seg[],int ind,int low, int high){
        if(low == high){
            seg[ind] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(arr, seg, 2 * ind + 1, low, mid);
        build(arr,seg,2 * ind + 2, mid + 1, high);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }
}
