import java.util.ArrayList;
public class combination_sum_1 {
    public static void main(String[] args) {
        /*
        * Given an array of distinct integers and a target,
        * you have to return the list of all combinations where the chosen numbers sum to target.
        * You may return the combinations in any order
        * */

        //Example:
        /*
               Input: array = [2,3,6,7], target = 7
               Output: [[2,2,3],[7]]

             Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
             7 is a candidate, and 7 = 7.
             These are the only two combinations.

        */
        int[] arr={2,3,6,7};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=get_generated(arr,7);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> get_generated(int[] arr,int target){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        generate_combination(arr,0,target,new ArrayList<>(),ans);
        return ans;
    }

    public static void generate_combination(int[] arr, int index, int target,  ArrayList<Integer> temp,
                                            ArrayList<ArrayList<Integer>> ans){
        if(index>=arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(target>=arr[index]){
            temp.add(arr[index]);
            generate_combination(arr,index,target-arr[index],temp,ans);
            temp.remove(temp.size()-1);
        }
        generate_combination(arr,index+1,target,temp,ans);
    }
}
