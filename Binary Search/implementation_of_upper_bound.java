public class implementation_of_upper_bound {
    public static void main(String[] args) {
        //smallest index (i) such that arr[i]>x;
        int[] arr={1,2,4,5,6,9};
        System.out.println(upper_bound(arr,4));
    }


    public static int upper_bound(int[] arr,int x){
        int n=arr.length;
        int ans=n; // if we don't find any such index our answer will be hypothetical index of array size;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else if(arr[mid]<=x){
                low=mid+1;
            }
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }
}
