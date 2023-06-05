/*
*  TC-->O(nlogn) in all cases;
*  SC-->O(n);
*
* */

import java.util.ArrayList;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr={6,4,3,9,1,0,1,6,7,8,3};
        System.out.println("The sorted array using merge sort:");
        Merge_Sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void Merge_Sort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        Merge_Sort(arr,low,mid);
        Merge_Sort(arr,mid+1,high);
        Merge(arr,low,mid,high);
    }

    public static void Merge(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<=mid&&j<=high){
            if(arr[i]<=arr[j]){
                ans.add(arr[i++]);
            }
            else{
                ans.add(arr[j++]);
            }
        }
        while(i<=mid){
            ans.add(arr[i++]);
        }
        while(j<=high){
            ans.add(arr[j++]);
        }
        for(int k=low;k<=high;k++){
            arr[k]=ans.get(k-low);
        }
    }
}
