public class Maximum_sum_subarray_of_size_k_sliding_window {
    /*
     * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
     */
    public static void main(String[] args) {
        int arr[] = {100,200,300,400};
        int k = 2;
        System.out.println(max_sum_subarray_of_size_k(arr,k));
        System.out.println(optimal_approach(arr,k));
    }

    //bruteforce
    public static int max_sum_subarray_of_size_k(int arr[],int k){
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];
                if(j - i + 1 == k){
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }

    //optimal approach using sliding window;
    public static int optimal_approach(int arr[],int k){
        int n = arr.length;
        int max = 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        max = Math.max(max,sum);
        int start = 0;
        for(int i = k; i < n; i++){
            sum += arr[i];
            sum = sum - arr[start];
            max = Math.max(max,sum);
            start++;
        }
        return max;
    }
}
