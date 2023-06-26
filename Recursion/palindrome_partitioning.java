import java.util.ArrayList;

public class palindrome_partitioning {
    public static void main(String[] args) {
        String s="aabb";
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ans=generate(s);
        for(ArrayList<String> row:ans){
            for(String raj:row){
                System.out.print(raj+" ");
            }
            System.out.println();
        }

    }


    public static ArrayList<ArrayList<String>> generate(String s){
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<String> temp=new ArrayList<>();
        solve(s,0,ans,temp);
        return ans;
    }
    public static void solve(String s, int index, ArrayList<ArrayList<String>> ans, ArrayList<String> temp){
        if(index>=s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(is_pallindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                solve(s,i+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean is_pallindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
