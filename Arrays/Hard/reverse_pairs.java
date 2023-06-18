import java.util.ArrayList;

public class reverse_pairs {
    public static void main(String[] args) {
        //count pairs if(arr[i]>2*arr[j]);
        int[] arr={2,4,1,6,2,3,7};
        int[] arr1={2,4,1,6,2,3,7};
       System.out.println(mergesort(arr,0,arr.length-1));
        System.out.println(brute_force(arr1));
        
    }

    public static int brute_force(int[] arr){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>2*arr[j]){
                    count++;
                }
            }
        }
        return count;
        //TC=O(n^2);
        //SC=O(1);
    }


    //Optimized approach using divide and conquer;
    public static int mergesort(int[] arr,int low,int high){
        int n=arr.length;
        if(low>=high){
            return 0;
        }
        int count=0;
        int mid=(low+high)/2;
        count+=mergesort(arr,low,mid);
        count+=mergesort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
        //TC=O(nlogn);
        //SC=O(n);
    }
    public static int merge(int[] arr,int low,int mid,int high){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int j=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(j<=high&&arr[i]>2*arr[j]){
                j++;
            }
            count+=(j-(mid+1));
        }
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
        for(int i=low;i<=high;i++){
            arr[i]=ans.get(i-low);
        }
        return count;
    }
}
