import java.util.ArrayList;
import java.util.Collections;
public class subset_sum_1 {

    /*
    *
    Input: N = 3, arr[] = {5,2,1}
    Output: 0,1,2,3,5,6,7,8
    *

    * */
    public static void main(String[] args) {
        int[] arr={5,2,1};
        ArrayList<Integer> ans=new ArrayList<>();
        ans=get(arr);
        Collections.sort(ans);
        for(int num:ans){
            System.out.print(num+" ");
        }
    }

    public static ArrayList<Integer> get(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>();
        solve(arr,0,0,ans);
        return ans;
    }

    public static void solve(int[] arr, int index, int sum, ArrayList<Integer> ans){
        if(index>=arr.length){
            ans.add(sum);
            return;
        }
        sum+=arr[index];
        solve(arr,index+1,sum,ans);
        sum=sum-arr[index];
        solve(arr,index+1,sum,ans);
    }
}
