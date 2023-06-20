import java.util.ArrayList;
public class Generate_all_subsequences_whose_sum_equal_to_k {
    public static void main(String[] args) {
        int[] arr={1,2,1};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=get(arr,2);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

    }


    public static ArrayList<ArrayList<Integer>> get(int[] arr,int k){
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        generate(arr,0,0,k,new ArrayList<>(),ans);
        return ans;
    }
    public static void generate(int[] arr,int index, int sum, int k, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(index>=arr.length){
            if(sum==k){
                ans.add(new ArrayList<>(temp));

            }
            return;
        }
        temp.add(arr[index]);
        sum+=arr[index];
        generate(arr,index+1,sum,k,temp,ans);
        temp.remove(temp.size()-1);
        sum-=arr[index];
        generate(arr,index+1,sum,k,temp,ans);
        //TC=O(2^n);
        //SC=O(n);
    }
}

