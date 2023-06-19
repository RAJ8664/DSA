public class search_insert_position {
    public static void main(String[] args) {
        /*
        Problem Statement: You are given a sorted array arr of distinct values and a target value x.
        You need to search for the index of the target value in the array.
        If the value is present in the array, then return its index.
        Otherwise, determine the index where it would be inserted in the array while
        maintaining the sorted order.
        */
        int[] arr={1,2,4,7};
        System.out.println(search_insert(arr,6));

    }

    //just implement the lower bound;
    public static int search_insert(int[] arr,int x){
        int n=arr.length;
        int ans=n;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }
}
