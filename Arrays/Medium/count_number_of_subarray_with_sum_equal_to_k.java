import java.util.HashMap;

public class count_number_of_subarray_with_sum_equal_to_k {
    public static void main(String[] args) {
        int[] arr={3, 1, 2, 4};
        System.out.println(bruteforce(arr,6));
        System.out.println(optimal_appraoch(arr,6));
    }

    public static int bruteforce(int[] arr,int k){
        int n=arr.length;
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int optimal_appraoch(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int presum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            presum+=arr[i];
            int find=presum-k;

            //count+=map.getOrDefault(find,0);
            if(map.containsKey(find)){
                count+=map.get(find);
            }

            //map.put( presum, map.getOrDefaut(presum,0)+1);
            //instead of if and else condition written below;
            if(map.containsKey(presum)){
                int key=map.get(presum);
                map.put(presum,++key);
            }
            else{
                map.put(presum,1);
            }
        }
        return count;
        //TC=O(nlogn);
        //SC=O(b);
    }

}
