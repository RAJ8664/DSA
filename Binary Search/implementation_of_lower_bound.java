public class implementation_of_lower_bound {
    public static void main(String[] args) {
        //smallest index (i) such that arr[i]>=x;
        int[] arr={1,5,6,7,9,10};
        System.out.println(lower_bound(arr,3));
    }

    public static int lower_bound(int[] arr,int x){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n; // if we don't find any such index our answer will be hypothetical index of array size;
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
