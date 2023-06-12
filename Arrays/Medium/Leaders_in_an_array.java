import java.util.ArrayList;
import java.util.Collections;
public class Leaders_in_an_array {
    public static void main(String[] args) {
        int[] arr={4,7,1,0};
        ArrayList<Integer> ans=new ArrayList<>();
        ans=bruteforce(arr);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        ans.clear();
        System.out.println();
        ans=optimal_approach(arr);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<Integer> bruteforce(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            boolean flag=true;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.add(arr[i]);
            }
        }
        ans.add(arr[n-1]);
        return ans;
    }

    public static ArrayList<Integer> optimal_approach(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int current_max=arr[n-1];
        ans.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=current_max){
                ans.add(arr[i]);
                current_max=arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
