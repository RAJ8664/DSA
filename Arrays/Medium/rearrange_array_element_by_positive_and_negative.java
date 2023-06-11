import java.util.ArrayList;

public class rearrange_array_element_by_positive_and_negative {
    public static void main(String[] args) {
        int[] arr={9, 4, -2, -1, 5, 0, -5, -3, 2};
        bruteforce(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bruteforce(int[] arr){
        //code works for any time of input array;
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> ans1=new ArrayList<>();
        ArrayList<Integer> raj=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                ans.add(arr[i]);
            }
            else{
                ans1.add(arr[i]);
            }
        }
        int l=0;
        int r=0;
        while(l<ans.size()&&r<ans1.size()){
            raj.add(ans.get(l++));
            raj.add(ans1.get(r++));
        }
        while(l<ans.size()){
            raj.add(ans.get(l++));
        }
        while(r<ans1.size()){
            raj.add(ans1.get(r++));
        }
        for(int i=0;i<raj.size();i++){
            arr[i]=raj.get(i);
        }
        //TC=O(n);
        //SC=O(n);
    }

    public static int[] bruteforce_1(int[] arr){
        //only works if input array has even length and same positive and negative number;
        int n=arr.length;
        int[] ans=new int[n];
        int pi=0;
        int ni=1;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                arr[pi]=arr[i];
                pi+=2;
            }
            else{
                arr[ni]=arr[i];
                ni+=2;
            }
        }
        return arr;
        //TC=O(n);
        //SC=O(1) if we ignor our ans array;
    }
}
