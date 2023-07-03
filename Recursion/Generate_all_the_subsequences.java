import java.util.ArrayList;
public class Generate_all_the_subsequences {
    //done both for string as well as numbers;
    public static void main(String[] args) {
        String s="abc";
        ArrayList<String> ans=new ArrayList<>();
        ans=getsubsequences(s);
        for(String ch:ans){
            System.out.print(ch+" ");
        }

        int[] arr={1,2,3};
        ArrayList<ArrayList<Integer>> ans1=new ArrayList<>();
        ans1=bruteforce(arr);
        for(ArrayList<Integer> raj :ans1){
            for(int ele:raj){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    //power set algorithm;
    public static ArrayList<String> bruteforce(String s){
        int n=s.length();
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            String temp="";
            for(int j=0;j<n;j++){
                //check if ith bit is set;
                if((i&(1<<j))!=0){
                    temp=temp+s.charAt(j);
                }
            }
            ans.add(temp);
        }
        return ans;
        //TC=O(n*2^n);
        //SC=O(n);
    }

    

    public static ArrayList<String> getsubsequences(String s){
        ArrayList<String> ans=new ArrayList<>();
        optimal_approach(0,s,"",ans);
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> getsubsequences(int[] arr){
        int n=arr.length;
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        optimal_approach(arr,0,temp,ans);
        return ans;
    }

    public static void optimal_approach(int index,String s,String temp,ArrayList<String> ans){
        if(index>=s.length()){
            ans.add(temp);
            return;
        }
        temp=temp+s.charAt(index);
        optimal_approach(index+1,s,temp,ans);
        temp=temp.substring(0,temp.length()-1);
        optimal_approach(index+1,s,temp,ans);
        //TC=O(2^n);
        //SC=O(n);
    }

    public static void optimal_approach(int[] arr,int index,
                                ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        int n=arr.length;
        if(index>=n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[index]);
        optimal_approach(arr,index+1,temp,ans);
        temp.remove(temp.size()-1);
        optimal_approach(arr,index+1,temp,ans);
        //TC=O(2^n);
        //SC=O(n);
    }
}
