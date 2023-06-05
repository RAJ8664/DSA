public class Check_if_array_Is_Sorted {
    public static void main(String[] args) {
        int[] arr={5,3,52,1,0,};

        int[] arr1={1,2,3,4,5,6};
        System.out.println(Brute_Force_Approach(arr));
        System.out.println(Optimal_Approach(arr));

        System.out.println(Brute_Force_Approach(arr1));
        System.out.println(Optimal_Approach(arr1));
    }
    public static boolean Brute_Force_Approach(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    return false;
                }
            }
        }
        return true;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static boolean Optimal_Approach(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
        //TC=O(n);
        //SC=O(1);
    }
}
