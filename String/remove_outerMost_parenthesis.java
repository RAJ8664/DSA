package string;
import java.util.Stack;
public class remove_outerMost_parenthesis {
    /*
    * Input: s = "(()())(())"
      Output:     "()()()"
    *
    *
    * */
    public static void main(String[] args) {
        String s="(()())(())";
        System.out.println(bruteforce(s));
        System.out.println(optimal_approach(s));
    }



    public static String bruteforce(String s){
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(st.size()>0){
                    sb.append(ch);
                }
                st.push(ch);
            }
            else{
                st.pop();
                if(st.size()>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
        //TC=O(n);
        //SC=O(n);
    }
    

    public static String optimal_approach(String s){
        int oc=0;
        int cc=0;
        String ans="";
        int start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                oc++;
            }
            else if(s.charAt(i)==')'){
                cc++;
            }
            if(oc==cc){
                ans+=s.substring(start+1,i);
                start=i+1;
            }
        }
        return ans;
        //TC=O(n);
        //SC=O(1);
    }
}
