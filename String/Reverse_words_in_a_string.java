import java.util.Stack;

public class Reverse_words_in_a_string {
    public static void main(String[] args) {
        String s="RAJ ROY";
        System.out.println(optimal_approach(s));

    }

    public static String bruteforce(String s){
        s=s+" ";
        Stack<String> st=new Stack<>();
        String str="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                st.push(str);
                str="";
            }
            else{
                str=str+s.charAt(i);
            }
        }
        String ans="";
        while(st.size()!=1){
            ans+=st.peek()+" ";
            st.pop();
        }
        ans+=st.peek();
        return ans;
        //TC=O(n);
        //SC=O(n);
    }

    public static String optimal_approach(String s){
        int i=0;
        int j=s.length()-1;
        String temp="";
        String ans="";
        while(i<=j){
            if(s.charAt(i)!=' '){
                temp+=s.charAt(i);
            }
            else if (s.charAt(i)==' '){
                if(ans.length()!=0){
                    ans=temp+" "+ans;
                }
                else{
                    ans=temp;
                }
                temp="";

            }
            i++;
        }
        if(temp.length()!=0){
            if(ans.length()!=0){
                ans=temp+" "+ans;
            }
            else{
                ans=temp;
            }
        }
        return ans;
        //TC=O(n);
        //SC=O(1);

    }
}
