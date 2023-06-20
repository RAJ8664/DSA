import java.util.ArrayList;
public class combination_sum_3 {
    /*
    *
    *Find all valid combinations of K numbers that sum upto to N
    * such that the following conditions are true:

    Only number 1 through 9 are used.
    Each number is used atmost once.
    Return the list of all possible valid combinations.

    * */
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int K = 3;
        int N = 9;
        ans=get(arr,K,N);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> get(int[] arr, int k, int s){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(arr,k,0,0,s,new ArrayList<>(),ans);
        return ans;
    }

    public static void solve(int[] arr,int k,int index,int sum,int s,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(index>=arr.length){
            if(sum==s&&temp.size()==k){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        sum+=arr[index];
        temp.add(arr[index]);
        solve(arr,k,index+1,sum,s,temp,ans);
        sum=sum-arr[index];
        temp.remove(temp.size()-1);
        solve(arr,k,index+1,sum,s,temp,ans);
    }

}
