public class Book_Allocation {
    /*
    * You have N books, each with Ai number of pages. M students need to be allocated contiguous books,
    * with each student getting at least one book. Out of all the permutations,
    * the goal is to find the permutation where the student with the most pages allocated to him gets the minimum number of pages,
    *  out of all possible permutations.
    * */
    public static void main(String[] args) {
        int[] arr={12,34,67,90};
        System.out.println(optimal_approach(arr,2));
    }

    public static int optimal_approach(int[] arr,int m){
        int n=arr.length;
        if(m>n){
            return -1;
        }
        int min=arr[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]>min){
                min=arr[i];
            }
        }
        int low=min;
        int high=sum;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(!is_possible(arr,mid,m)){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;

    }

    public static int bruteforce(int[] arr,int m){
        int n=arr.length;
        if(m>n){
            return -1;
        }
        int min=arr[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]>min){
                min=arr[i];
            }
        }
        for(int i=min;i<=sum;i++){
            if(is_possible(arr,i,m)){
                return i;
            }
        }
        return -1;
        //TC=O(n^2);
        //SC=O(1);

    }
    public static boolean is_possible(int[] arr,int x,int m){
        int n=arr.length;
        int count=1;
        int pagessum=0;
        for(int i=0;i<n;i++){
            if(pagessum+arr[i]<=x){
                pagessum+=arr[i];
            }
            else{
                count++;
                if(count>m||arr[i]>x){
                    return false;
                }
                pagessum=arr[i];
            }
        }
        return true;
    }
}
