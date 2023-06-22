public class koko_eating_banana {
    /*
    * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

    Koko can decide her bananas-per-hour eating speed of k. Each hour,
    *  she chooses some pile of bananas and eats k bananas from that pile. If the pile has less
    *  than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards
    * return.
    Return the minimum integer k such that she can eat all the bananas within h hours.
    * */
    public static void main(String[] args) {
        int[] arr={30,11,23,4,20};
        System.out.println(optimal_approach(arr,6));
    }

    public static int bruteforce(int[] arr,int h){
        int n=arr.length;
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        for(int i=1;i<=max;i++){
            long count=0;
            for(int j=0;j<n;j++){
                if((arr[j]%i)==0){
                    count+=arr[j]/i;
                }
                else{
                    count+=arr[j]/i+1;
                }
            }
            if(count<=h){
                return i;
            }
        }
        return -1;
        //TC=O(maxof(array)*n);
        //SC=O(1);
    }

    public static int optimal_approach(int[] arr,int h){
        int n=arr.length;
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(!is_possible(arr,mid,h)){
                low=mid+1;
            }
            else{
                high=mid-1;
                ans=mid;
            }
        }
        return ans;
        //TC=O(n*log(maxofarray));
        //SC=O(1);

    }
    public static boolean is_possible(int[] arr,int x,int h){
        int n=arr.length;
        long count=0;
        for(int i=0;i<n;i++){
            if(arr[i]%x==0){
                count+=arr[i]/x;
            }
            else{
                count+=arr[i]/x+1;
            }
        }
        if(count<=h){
            return true;
        }
        return false;
    }
}
