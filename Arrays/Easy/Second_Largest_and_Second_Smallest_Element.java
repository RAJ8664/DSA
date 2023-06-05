import java.util.ArrayList;
import java.util.Arrays;
public class Second_Largest_and_Second_Smallest_Element {
    public static void main(String[] args) {
        int[] arr={5,2,8,1,0,0,6,9};
        ArrayList<Integer> brute=new ArrayList<>();
        ArrayList<Integer> optimal=new ArrayList<>();
        brute=Brute_Force_Approach(arr);
        optimal=Optimal_Approach(arr);
        System.out.println("The elements are:");
        for(int i=0;i<brute.size();i++){
            System.out.print(brute.get(i)+" ");
        }
        System.out.println();
        System.out.println("The elements are:");
        for(int i=0;i<optimal.size();i++){
            System.out.print(optimal.get(i)+" ");
        }
    }


    public static ArrayList<Integer> Brute_Force_Approach(int[] arr){
        //This approach may not work if there is presence of duplicate elements in the array
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        if(n==0||n==1){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        Arrays.sort(arr);
        int second_small=arr[1];
        int second_large=arr[n-2];
        ans.add(second_small);
        ans.add(second_large);
        return ans;
        //TC=O(nlogn);
        //SC=O(1);
    }

    public static ArrayList<Integer> Optimal_Approach(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        if(n==0||n==1){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int first_max=Integer.MIN_VALUE;
        int first_min=Integer.MAX_VALUE;
        int second_max=Integer.MIN_VALUE;
        int second_min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            first_max=Math.max(first_max,arr[i]);
            first_min=Math.min(first_min,arr[i]);
        }
        for(int j=0;j<n;j++){
            if(arr[j]>second_max&&arr[j]!=first_max){
                second_max=arr[j];
            }
            if(arr[j]<second_min&&arr[j]!=first_min){
                second_min=arr[j];
            }
        }
        ans.add(second_min);
        ans.add(second_max);
        return ans;
        //TC=O(n);
        //SC=O(1);
    }
}
