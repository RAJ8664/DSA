public class min_weight_to_ship_package_within_d_days {
    public static void main(String[] args) {
        int arr[] = {5,4,5,2,3,4,5,6};
        System.out.println(binary_search(arr,5));
    }
    
    public static int binary_search(int arr[],int d){
        int n = arr.length;
        int max = arr[0];
        int sum = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }
        int low = max;
        int high = sum;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(is_possible(arr,mid,d)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean is_possible(int arr[],int mid,int d){
        int n = arr.length;
        int count = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + arr[i] > mid){
                count++;
                sum = arr[i];
            }
            else{
                sum += arr[i];
            }
        }
        if(count <= d){
            return true;
        }
        return false;
    }
}
