public class find_how_many_times_an_array_is_rotated {
    //just find the index where the smallest element is present int the array;
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(optimal_approach(arr));
        System.out.println(brute_force(arr));
    }


    public static int brute_force(int[] arr){
        int n=arr.length;
        int min=arr[0];
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
                ans=i;
            }
        }
        return ans;
        //TC=O(n);
        //SC=O(1)
    }
    public static int optimal_approach(int[] arr){
        int n=arr.length;
        int ans=-1;
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high){
            //entire array is sorted
            if(arr[low]<=arr[high]){
                if(arr[low]<min){
                    min=arr[low];
                    ans=low;
                    break;
                }
            }
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min=arr[low];
                    ans=low;
                }
                low=mid+1;
            }
            else{
                if(arr[mid]<min){
                    min=arr[mid];
                    ans=mid;

                }
                high=mid-1;
            }
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }
}
