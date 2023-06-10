public class sort_an_array_of_0_1_2 {
    public static void main(String[] args) {
        int[] arr={1,2,0,0,2,2,1,0,1,2};
        optmal_sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //you can use any of the n^2 sorting algorith, for the brute force approach and also
    //inbuilt method for better approach;
    //just writing the optimal approach;

    public static void optmal_sort(int[] arr){
        int n=arr.length;
        int zero_count=0;
        int one_count=0;
        int two_count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zero_count++;
            }
            if(arr[i]==one_count){
                one_count++;
            }
            else{
                two_count++;
            }
        }
        for(int i=0;i<zero_count;i++){
            arr[i]=0;
        }
        for(int i=zero_count;i<one_count+zero_count;i++){
            arr[i]=1;
        }
        for(int i=one_count+zero_count;i<n;i++){
            arr[i]=2;
        }
        //TC=O(n);
        //SC=O(1);
    }
}
