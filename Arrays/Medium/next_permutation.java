public class next_permutation {
    public static void main(String[] args) {
        int[] arr={2,1,4,5,3};
        System.out.println("the next permutation of array is:");
        Next_Permutation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }



    public static void Next_Permutation(int[] arr){
        int n=arr.length;
        int i=0;
        int j=0;
        for(i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                break;
            }
        }
        if(i<0){
            reverse(arr,0,n-1);
        }
        else{
            for(j=n-1;j>i;j--){
                if(arr[j]>arr[i]){
                    break;
                }
            }
            swap(arr,i,j);
            reverse(arr,i+1,n-1);
        }
    }
    public static void swap(int[] arr,int s,int e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
    }
    public static void reverse(int[] arr,int s,int e){
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}
