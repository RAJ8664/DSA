import java.util.Arrays;
import java.util.HashMap;

public class Find_the_number_that_appears_once_and_the_other_numbers_twice {
    public static void main(String[] args) {
        int[] arr={2,2,1};
        System.out.println(optimal_approach(arr));
    }
    public static int brute_force(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]&&i!=j){
                    flag=1;

                }
            }
            if(flag==0){
                return arr[i];
            }
        }
        return -1;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int better_approach(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i+=2){
            if(arr[i]!=arr[i+1]){
                return arr[i];
            }
        }
        return arr[n-1];
        //TC=O(nlogn);
        //SC=O(1);
    }

    public static int better_approach_1(int[] arr){
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int key=map.get(arr[i]);
                map.put(arr[i],++key);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for(int i=0;i<n;i++){
            if(map.get(arr[i])==1){
                return arr[i];
            }
        }
        return -1;
        //TC=O(n);
        //SC=O(n);
    }

    public static int optimal_approach(int[] arr){
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans^arr[i];
        }
        return ans;
        //TC=O(n);
        //SC=O(1);

    }
}
