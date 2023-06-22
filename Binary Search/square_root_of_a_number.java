public class square_root_of_a_number {
    public static void main(String[] args) {
        int n=26;
        System.out.println(optimal_approach(n));
    }

    public static int bruteforce(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            if(i*i<=n){
                ans=i;
            }
            else{
                break;
            }
        }
        return ans;
        //TC=O(n);
        //SC=O(1);
    }

    public static long optimal_approach(int n){
        long ans=1;
        long low=1;
        long high=n;
        while(low<=high){
            long mid=(int)(low+(high-low)/2);
            if((long)(mid*mid)<=n){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }
}
