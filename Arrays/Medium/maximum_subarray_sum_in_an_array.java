public class maximum_subarray_sum_in_an_array {
    public static void main(String[] args) {
        int[] arr={1,2,7,-4,3,2,-10,9,1};
        System.out.println(bruteforce_approach(arr));
        System.out.println(optimal_approach(arr));

    }

    public static int bruteforce_approach(int[] arr){
        int n=arr.length;
        int max_sum=Integer.MIN_VALUE;
        int current_sum=0;
        for(int i=0;i<n;i++){
            current_sum=0;
            for(int j=i;j<n;j++){
                current_sum+=arr[j];
                max_sum=Math.max(max_sum,current_sum);
            }
        }
        return max_sum;
        //TC=O(n^2);
        //SC=O(1);

    }

    //kadane's algorithm;
    public static int optimal_approach(int[] arr){
        int n=arr.length;
        int max_sum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>max_sum){
                max_sum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max_sum;
        //TC=O(n);
        //SC=O(1);
    }


}
