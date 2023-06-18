import java.util.ArrayList;

public class inversion_count {
    public static void main(String[] args) {
        /*
        * For an array, inversion count indicates how far (or close) the array is from being sorted.
        * If array is already sorted then the inversion count is 0.
        *  If an array is sorted in the reverse order then the inversion count is the maximum;
        */
        int[] arr={2, 4, 1, 3, 5};
        System.out.println(merge_sort(arr,0,arr.length-1));
    }
    public static int bruteforce(int[] arr){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
        //TC=O(n^2);
        //SC=(1);
    }

    //optimized approach using divide and conquer;
    public static int merge_sort(int[] arr,int low,int high){
        int count=0;
        if(low>=high){
            return 0;
        }
        int mid=low+(high-low)/2;
        count+=merge_sort(arr,low,mid);
        count+=merge_sort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }
    public static int merge(int[] arr,int low,int mid,int high){
        int count=0;
        int j=mid+1;
        for(int i=0;i<=mid;i++){
            while(j<=high&&arr[i]>arr[j]){
                j++;
            }
            count+=(j-(mid+1));
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int left=low;
        int right=mid+1;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                ans.add(arr[left++]);
            }
            else{
                ans.add(arr[right++]);
            }
        }
        while(left<=mid){
            ans.add(arr[left++]);
        }
        while(right<=high){
            ans.add(arr[right++]);
        }
        int k=0;
        for(int i=low;i<=high;i++){
            arr[i]=ans.get(k++);
        }
        return count;
        //TC=O(nlogn);
        //SC+O(n);
    }
}
