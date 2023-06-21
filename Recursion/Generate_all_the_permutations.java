import java.util.ArrayList;
public class Generate_all_the_permutations {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean[] vis=new boolean[arr.length+1];
        ans=get_optimal(arr);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> get_bruteforce(int[] arr,boolean[] vis){
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        bruteforce(arr,new ArrayList<>(),ans,vis);
        return ans;
    }

    public static void bruteforce(int[] arr,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,boolean[] vis){
        if(temp.size()==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(arr[i]);
                bruteforce(arr,temp,ans,vis);
                temp.remove(temp.size()-1);
                vis[i]=false;
            }
        }
        //TC=O(n!*n);
        //SC=O(n)+O(n) one 'n' beacuse of temp arraylist and one 'n' for visisted array;
        // also we are ignoring our answer arraylist;
    }


    public static ArrayList<ArrayList<Integer>> get_optimal(int[] arr){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        optmial_approach(0,arr,ans);
        return ans;
    }

    public static void optmial_approach(int index,int[] arr,ArrayList<ArrayList<Integer>> ans){
        if(index==arr.length){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            ans.add(new ArrayList<>(temp));
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            optmial_approach(index+1,arr,ans);
            swap(arr,index,i);
        }
        //TC=O(n!*n);
        //SC=O(n);
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
