import java.util.ArrayList;
import java.util.Arrays;
public class subset_sum_2 {
    /*
    * an input array consist of duplicate elements,generate all the possible subsequences of an array and
    * final answer must not contain duplicate subsequences;
    *
    *
    *
        Input: 
        nums = [1,2,2]
        Output:
        [[],[1],[1,2],[1,2,2],[2],[2,2]]
        Explanation:
        We can have subsets ranging from length 0 to 3. which are listed above.
        Also the subset [1,2] appears twice but is printed only once as
        we require only unique subsets.
    *
    *
    *
    * */
    public static void main(String[] args) {
        int[] arr={1,2,2};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=get(arr);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Integer>> get(int[] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(arr,0,new ArrayList<>(),ans);
        return ans;
    }

    public static void solve(int[] arr,int index, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(index>=arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[index]);
        solve(arr,index+1,temp,ans);
        temp.remove(temp.size()-1);
        while(index+1<arr.length&&arr[index]==arr[index+1]){
            index++;
        }

        solve(arr,index+1,temp,ans);
    }
}
