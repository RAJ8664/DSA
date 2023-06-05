/*
    TC--> best and average case O(nlogn);
            worst case O(n^2);
    SC--> O(1) //not counting the recursion stack space

* */


public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr={5,1,8,2,0,1,4,7};
        System.out.println("the sorted array using quick sort: ");
        Quick_Sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void Quick_Sort(int[] arr,int low,int high){
        if(low<high){
            int partitioner_index=partition(arr,low,high);
            Quick_Sort(arr,low,partitioner_index-1);
            Quick_Sort(arr,partitioner_index+1,high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot&&i<=high-1){
                i++;
            }
            while(arr[j]>=pivot&&j>=low+1){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
}
