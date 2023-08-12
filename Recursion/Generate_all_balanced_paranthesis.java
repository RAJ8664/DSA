import java.util.ArrayList;

public class Generate_all_balanced_paranthesis {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> ans = new ArrayList<>();
        ans = get_paranthesis(n);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) +" ");
        }
    }

    public static ArrayList<String> get_paranthesis(int n){
        ArrayList<String> ans = new ArrayList<>();
        solve(n,"",0,0,ans);
        return ans;
    }
    public static void solve(int n , String temp , int oc , int cc, ArrayList<String> ans ){
        if(temp.length() == 2 * n){
            ans.add(temp);
            return;
        }
        if(oc < n){
            solve(n , temp + "(" , oc + 1, cc, ans);
        }
        if(oc > cc){
            solve(n , temp + ")" , oc, cc + 1,ans);
        }
    }
}
