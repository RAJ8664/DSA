import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class four_sum {
    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
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
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    for(int l=k+1;l<n;l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l]==target){
                            ArrayList<Integer> temp=new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[l]);
                            //if unique combination is asked in question;
                            Collections.sort(temp);
                            if(!ans.contains(temp)){
                                ans.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return ans;
        //TC=O(n^4);
        //SC=(1) if we ignore our answer arraylist;
    }


    public static ArrayList<ArrayList<Integer>> optimal_approach(int[] arr,int target){
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int low=j+1;
                int high=n-1;
                int sum=target-arr[i]-arr[j];
                while(low<high){
                    if(arr[low]+arr[high]==sum){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        ans.add(temp);
                        //unique combination steps;
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
                while(j+1<n&&arr[j]==arr[j+1]){
                    j++;
                }
            }
            while(i+1<n&&arr[i]==arr[i+1]){
                i++;
            }
        }
        return ans;
        //TC=O(nlogn)+O(n^3);
        //SC=O(1) if we ignor our answer arraylist;
    }
}
