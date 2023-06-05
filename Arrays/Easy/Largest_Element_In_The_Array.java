import java.util.Arrays;

public class Largest_Element_In_The_Array {
    public static void main(String[] args) {
        int[] arr={5,7,1,9,10};
        System.out.println("Largest element is:"+(Brute_Force_Approach(arr)));
        System.out.println("Largest element is:"+(Optimal_Approach(arr)));
    }
    private static int Brute_Force_Approach(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        return arr[n-1];
        //TC=O(nlogn);
        //SC=O(1);
    }

    private static int Optimal_Approach(int[] arr){
        int n=arr.length;
        int maximum=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>maximum){
                maximum=arr[i];
            }
        }
        return maximum;
        //TC=O(n);
        //SC=O(1);
    }

}
