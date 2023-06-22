public class Minimum_days_to_make_M_bouquets {
    /*
    *To make one bouquet we need K adjacent flowers from the garden.
    *Here the garden consists of N different flowers, the ith flower will bloom in the bloomDay[i].
    *Each flower can be used inside only one bouquets.
    *We have to find the minimum number of days need to wait to make M bouquets from the garden.
    *If we cannot make m bouquets, then return -1.
    * */
    public static void main(String[] args) {
        int[] arr={5, 5, 5, 5, 10, 5, 5};
        System.out.println(optimal_approach(arr,2,3));
    }

    public static boolean is_possible(int[] arr,int x,int m,int k){
        int count=0;
        int mcount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>x){
                mcount+=count/k;
                count=0;
            }
            else{
                count++;
            }
        }
        mcount+=count/k;
        if(mcount>=m){
            return true;
        }
        return false;
    }

    public static int optimal_approach(int[] arr,int m,int k){
        int n=arr.length;
        if((long)m*k>n){
            return -1;
        }
        int min=arr[0];
        int max=arr[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        int low=min;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(!is_possible(arr,mid,m,k)){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
        //TC=O(n*log(maxofarray));
        //SC=O(1);
    }

    public static int bruteforce(int[] arr,int m,int k){
        int n=arr.length;
        if((long)m*k>n){
            return -1;
        }
        int min=arr[0];
        int max=arr[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        for(int i=min;i<=max;i++){
            if(is_possible(arr,i,m,k)){
                return i;
            }
        }
        return -1;
        //TC=O(maxofarray*n);
        //SC=O(1);
    }
}
