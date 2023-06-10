import java.util.HashMap;

public class Majority_Element {
    public static void main(String[] args) {
        //element that occured more than n/2 times;
        int[] arr={2, 2, 1, 1, 1, 2, 2};
        System.out.println(brute_force(arr));
        System.out.println(better_approach(arr));
        System.out.println(optimal_approach(arr));
    }

    public static int brute_force(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/2){
                return arr[i];
            }
        }
        return -1;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int better_approach(int[] arr){
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
            if(map.get(arr[i])>n/2){
                return arr[i];
            }
        }
        return -1;
        //TC=O(nlogn);
        //SC=O(n);

    }

    public static int optimal_approach(int[] arr){
        int n=arr.length;
        int count=0;
        int majority=-1;
        for(int i=0;i<n;i++){
            if(count==0){
                majority=arr[i];
                count++;
            }
            else{
                if(arr[i]==majority){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        int count1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==majority){
                count1++;
            }
        }
        if(count1>n/2){
            return majority;
        }
        return -1;
        //TC=O(n);
        //SC=O(1);
    }



}
