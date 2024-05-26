import java.util.HashMap;

public class Longest_Subarray_with_given_Sum_K {
    public static void main(String[] args) {
        int[] arr={2,3,5};
        System.out.println(better_approach(arr,5));
        System.out.println();

    }
    public static int brute_force(int[] arr,int k){
        int n=arr.length;
        int maxlength = 0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    maxlength=Math.max(maxlength,j-i+1);
                }
            }
        }
        return maxlength;
        //TC=O(n ^ 2);
        //SC=O(1);
    }

    public static int better_approach(int[] arr,int k){
        //optimal approach if there is negative numbers in an array;
        //if there is only positive numbers in the array we can optimise the code;
        int n=arr.length;
        int presum=0;
        int maxlength=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            presum += arr[i];
            if (presum == k) {
                maxlength = Math.max(maxlength, i + 1);
            }
            int remaining = presum - k;
            if (map.containsKey(remaining)) {
                maxlength = Math.max(maxlength, i - map.get(remaining));
            }
            if(!map.containsKey(presum)){
                map.put(presum,i);
            }
        }
        return maxlength;
        //TC=O(n);
        //SC=O(n);
    }

    public static int optimal_approach(int[] arr,int k){
        //if there is presence of only numbers greater than or equal to 0 in the array;
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        int maxlen=0;
        while(j<n){
            sum+=arr[j];
            if(sum>k){
                sum=sum-arr[i];
                i++;
            }
            if(sum==k){
                maxlen=Math.max(maxlen,j-i+1);
            }
            j++;
        }
        return maxlen;
        //TC=O(n);
        //SC=O(1);
    }
}
