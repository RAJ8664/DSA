public class Binary_Search_to_find_target_in_sorted_array {
    public static void main(String[] args) {
        int[] arr={2,3,7,10,13,14,17};
        System.out.println(binary_search(arr,14));
    }

    public static int binary_search(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
        //TC=O(logn) provided that the input array was already sorted;
        //SC=O(1)
    }
}
