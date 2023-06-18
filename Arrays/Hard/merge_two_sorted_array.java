import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class merge_two_sorted_array {
    public static void main(String[] args) {

    }

    public static void bruteforce(int[] arr1,int[] arr2){
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr1.length;
        int m=arr2.length;
        for(int i=0;i<arr1.length;i++){
            ans.add(arr1[i]);
        }
        for(int j=0;j<arr2.length;j++){
            ans.add(arr2[j]);
        }
        Collections.sort(ans);
        int k=0;
        int r=0;
        for(int i=0;i<arr1.length;i++){
            arr1[i]=ans.get(k++);
        }
        for(int j=0;j<arr2.length;j++){
            arr2[j]=ans.get(k++);
        }
        //TC=O(n+m)log(n+m);
        //SC=O(n+m);
    }

    public static void better_approach(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(arr1[i]<=arr2[j]){
                ans.add(arr1[i++]);
            }
            else{
                ans.add(arr2[j++]);
            }
        }
        while(i<n){
            ans.add(arr1[i++]);
        }
        while(j<m){
            ans.add(arr2[j++]);
        }
        int k=0;
        for(int l=0;l<n;l++){
            arr1[l]=ans.get(k++);
        }
        for(int r=0;r<m;r++){
            arr2[r]=ans.get(k++);
        }
        //TC=O(n+m);
        //SC=O(n+m);
    }

    public static void optimized_approach(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int i=n-1;
        int j=0;
        while(i>=0&&j<m){
            if(arr1[i]>arr2[j]){
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i--;
                j++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //TC=O(nlogn)+O(mlogm);
        //SC=O(1);
    }
}
