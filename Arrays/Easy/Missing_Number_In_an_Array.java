import java.util.ArrayList;

public class Missing_Number_In_an_Array {
    public static void main(String[] args) {
        int[] arr={1,3,4,5};
        System.out.println(optimal_approach_1(arr,arr.length+1));
    }
    public static int brute_force_approach(int[] arr,int N){
        for(int i=1;i<=N;i++){
            int flag=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return -1;
        //TC=O(N^2);
        //SC=O(1);
    }


    public static int better_approach(int[] arr,int N){
        //here N is the size of array including the missing number;
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(arr[i]);
        }
        for(int i=1;i<=N;i++){
            if(!ans.contains(i)){
                return i;
            }
        }
        return -1;
        //TC=O(N);
        //Sc=O(N);
    }

    public static long optimal_approach(int[] arr,int N){
        long actual=N*(N+1)/2;
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return actual-sum;
        //TC=O(N);
        //SC=O(1);
    }


    //slightly better;
    public static int optimal_approach_1(int[] arr,int N){
        int n=arr.length;
        int xor1=0;
        int xor2=0;
        for(int i=1;i<=N;i++){
            xor1=xor1^i;
        }
        for(int i=0;i<arr.length;i++){
            xor2=xor2^arr[i];
        }
        return xor1^xor2;
        //TC=O(N);
        //SC=O(1);

    }
}
