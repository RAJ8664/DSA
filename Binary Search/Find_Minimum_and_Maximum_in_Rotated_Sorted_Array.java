public class Find_Minimum_and_Maximum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr={4,5,1,2,3};
        System.out.println(minimum(arr));
        System.out.println(maximum(arr));

    }

    public static int minimum(int[] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(arr[low]<=arr[high]){
                //entire array is sorted;
                min=Math.min(min,arr[low]);
                break;
            }
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                //left part of array is sorted;
                min=Math.min(min,arr[low]);
                low=mid+1;
            }
            else {
                //righ part of array is sorted;
                min=Math.min(min,arr[mid]);
                high=mid-1;
            }
        }
        return min;
        //TC=O(logn);
        //SC=O(1);
    }

    public static int maximum(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high){
            if(arr[low]<=arr[high]){
                //entire array is sorted;
                max=Math.max(max,arr[high]);
                break;
            }
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                //left part is sorted;
                max=Math.max(max,arr[mid]);
                low=mid+1;
            }
            else{
                //right part is sorted;
                max=Math.max(max,arr[high]);
                high=mid-1;
            }
        }
        return max;
        //TC=O(logn);
        //SC=O(1);
    }
}
