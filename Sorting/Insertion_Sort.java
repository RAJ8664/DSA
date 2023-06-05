/*
*   place the element where it should belong;
*   TC=O(N^2);
*   SC=O(1);
*
*
*/

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr={6,5,4,3,2,1};
        System.out.println("The sorted array using insertion sort:");
        Insertion_Sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void Insertion_Sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(i>0&&arr[i-1]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
                i--;
            }
        }
    }
}
