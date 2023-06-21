public class Find_peak_element {
    public static void main(String[] args) {
        int[] arr={1,13};
        System.out.println(brute_force(arr));
        System.out.println(optimal_approach(arr));
    }

    public static int brute_force(int[] arr){
        int n=arr.length;
        if(arr[0]>arr[1]){
            return arr[0];
        }
        if(arr[n-1]>arr[n-2]){
            return arr[n-1];
        }
        for(int i=1;i<n-1;i++){
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                return arr[i];
            }
        }
        return -1;
        //TC=O(n);
        //SC=O(1);
    }

    public static int optimal_approach(int[] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid = (low+high)/2;
            if(mid==0){
                return arr[0]>=arr[1]?arr[0]:arr[1];
            }
            if(mid==n-1){
                return arr[n-1]>=arr[n-2]?arr[n-1]:arr[n-2];
            }
            if(arr[mid]>=arr[mid+1]&&arr[mid]>=arr[mid-1]){
                return arr[mid];
            }
            else if(arr[mid]<arr[mid-1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return arr[low];
        //TC=O(logn);
        //SC=O(1);
    }

}
