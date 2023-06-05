import java.util.ArrayList;

public class Remove_Duplicates_From_Sorted_Array {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,2,2,3,3,4};
        int[] arr1={0,0,1,1,2,2,3,3,4};
        System.out.println("Final ans:");
        System.out.println(Brute_Force_Approach(arr));
        System.out.println(Optimal_Approach(arr1));
    }

    public static int Brute_Force_Approach(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!ans.contains(arr[i])){
                ans.add(arr[i]);
            }
        }
        int k=0;
        for(int i=0;i<ans.size();i++){
            arr[k++]=ans.get(i);
        }
        return ans.size();
        //TC=O(n);
        //SC=O(n);

    }

    public static int Optimal_Approach(int[] arr){
        int n=arr.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
        //TC=O(n);
        //SC=O(1);
    }
}
