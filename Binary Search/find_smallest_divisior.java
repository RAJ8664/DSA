public class find_smallest_divisior {
    /*
    * You are given an array of integers nums and an integer K, your task is to find the smallest positive integer divisor,
    * such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given integer K.
      Each result of the division is rounded to the nearest integer greater than or equal to that element. For Example: 7/3 = 3.
    * */
    public static void main(String[] args) {

    }

    public static boolean is_possible(int[] arr,int x,int k){
        int n=arr.length;
        long count=0;
        for(int i=0;i<n;i++){
            if(arr[i]%x==0){
                count+=arr[i]/x;
            }
            else{
                count+=arr[i]/x+1;
            }
        }
        if(count<=k){
            return true;
        }
        return false;
    }

    public static int bruteforce(int[] arr,int k){
        int n=arr.length;
        int max=arr[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        for(int i=1;i<=max;i++){
            if(is_possible(arr,i,k)){
                return i;
            }
        }
        return -1;
        //TC=O(maxofarray*n);
        //SC=O(1);
    }

    public static int optimal_approach(int[] arr,int k){
        int n=arr.length;
        int max=arr[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(!is_possible(arr,mid,k)){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;

            }
        }
        return ans;
        //TC=O(n*log(max0farray));
        //SC=O(1);

    }

}
