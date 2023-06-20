import java.util.ArrayList;
import java.util.Arrays;
public class combination_sum_2 {
    /*
     * Given an array of distinct integers and a target,
     * you have to return the list of all  unique combinations where the chosen numbers sum to target.
     * You may return the combinations in any order
     *
     * you cannot take element more than once;
     * */
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        int target=8;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=get(arr,target);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> get(int[] arr,int target){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(arr,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public static void solve(int[] arr,int index, int target, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(index>=arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(target>=arr[index]){
            temp.add(arr[index]);
            solve(arr,index+1,target-arr[index],temp,ans);
            temp.remove(temp.size()-1);
            while(index+1<arr.length&&arr[index]==arr[index+1]){
                index++;
            }
        }
        solve(arr,index+1,target,temp,ans);
    }

}
