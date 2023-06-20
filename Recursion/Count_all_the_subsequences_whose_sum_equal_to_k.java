public class Count_all_the_subsequences_whose_sum_equal_to_k {
    public static void main(String[] args) {
        int[] arr={1,2,1};
        System.out.println(count_all_subsequnces(arr,0,0,2));
    }


    public static int count_all_subsequnces(int[] arr,int index,int sum,int k){
        if(index>=arr.length){
            if(sum==k){
                return 1;
            }
            return 0;
        }
        sum+=arr[index];
        int l=count_all_subsequnces(arr,index+1,sum,k);
        sum-=arr[index];
        int r=count_all_subsequnces(arr,index+1,sum,k);
        return l+r;
        //TC=O(2^n);
        //SC=O(1) we are ignoring the stack space that is being used during recursion calls;
    }
}
