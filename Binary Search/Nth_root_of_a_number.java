public class Nth_root_of_a_number {
    public static void main(String[] args) {
        int n=2;
        int m=9;
        System.out.println(optimal_approach(n,m));
    }


    public static int bruteforce(int n,int m){
        for(int i=1;i<=m;i++){
            if(check(i,n)==m){
                return i;
            }
            else if(check(i,n)>m){
                break;
            }
        }
        return -1;
        //TC=O(m*n);
        //SC=O(1);
    }
    public static long check(int i,int n){
        long ans=1;
        for(int k=0;k<n;k++){
            ans=ans*i;
        }
        return ans;
    }


    public static int optimal_approach(int n,int m){
        int low=1;
        int high=m;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(mid,n)==m){
                return mid;
            }
            else if(Math.pow(mid,n)<m){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        //TC=logn*logm;
        //SC=O(1);
    }
}
