import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Three_Sum {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=bruteforce(arr,0);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> bruteforce(int[] arr,int target){
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==target){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        //if unique answer is asked in question;
                        Collections.sort(temp);
                        if(!ans.contains(temp)){
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
    }





    public static ArrayList<ArrayList<Integer>> optimal_approach(int[] arr,int target){
        int n=arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i==0||(i>0&&arr[i]!=arr[i-1])){
                int low=i+1;
                int high=n-1;
                int sum=target-arr[i];
                while(low<high){
                    if(arr[low]+arr[high]==sum){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        ans.add(temp);
                        //unique combination;
                        while(low<high&&arr[low]==arr[low+1]){
                            low++;
                        }
                        while(low<high&&arr[high]==arr[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(arr[low]+arr[high]<sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }
        }
        return ans;
        //TC=O(n^2)+O(nlogn);
        //SC=O(1) if we ignor our answer arraylist;
    }
}
