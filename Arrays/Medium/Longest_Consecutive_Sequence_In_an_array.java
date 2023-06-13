import java.util.Arrays;
import java.util.HashSet;

public class Longest_Consecutive_Sequence_In_an_array {
    public static void main(String[] args) {
        int[] arr={100, 200, 1, 3, 2, 4};
        System.out.println(optimal_appraoch(arr));
        System.out.println(bruteforce(arr));
        System.out.println(better_approach(arr));
    }

    public static boolean linear_search(int[] arr,int x){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                return true;
            }
        }
        return false;
    }
    public static int bruteforce(int[] arr){
        int n=arr.length;
        int max=1;
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            int current=arr[i];
             int count=1;
            while(linear_search(arr,current+1)){
                current++;
                count++;
            }
            max=Math.max(max,count);
        }
        return max;
        //TC=O(n);
        //SC=(1);
    }

    public static int better_approach(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        if(n==0){
            return 0;
        }
        int current=arr[0];
        int count=1;
        int max=1;
        for(int i=1;i<n;i++){
            if(arr[i]==current+1){
                count++;
            }
            else if(arr[i]!=current){
                count=1;
            }
            current=arr[i];
            max=Math.max(max,count);
        }
        return max;
        //TC=O(nlogn);
        //SC=O(1);

    }

    public static int optimal_appraoch(int[] arr){
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int max=1;
        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
        //TC=O(n);
        //SC=O(n);
    }


}
