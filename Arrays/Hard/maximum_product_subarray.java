public class maximum_product_subarray {
    public static void main(String[] args) {
        int[] arr={1,2,-3,0,-4,-5};
        System.out.println(bruteforce(arr));
        System.out.println(optimized_approach(arr));
    }


    public static int bruteforce(int[] arr){
        int n=arr.length;
        int max_prod=arr[0];
        for(int i=0;i<n;i++) {
            int prod = 1;
           for(int j=i;j<n;j++) {
               prod = prod * arr[j];
               max_prod = Math.max(max_prod, prod);
           }
        }
        return max_prod;
    }

    public static int optimized_approach(int[] arr){
        int n=arr.length;
        int max_left=Integer.MIN_VALUE;
        int max_right=Integer.MIN_VALUE;
        boolean zero=false;
        int prod=1;
        for(int i=0;i<n;i++){
            prod=prod*arr[i];
            if(arr[i]==0){
                zero=true;
                prod=1;
                continue;
            }
            max_left=Math.max(max_left,prod);
        }
        prod=1;
        for(int j=n-1;j>=0;j--){
            prod=prod*arr[j];
            if(arr[j]==0){
                zero=true;
                prod=1;
                continue;
            }
            max_right=Math.max(max_right,prod);
        }
        if(zero){
            return Math.max(0,Math.max(max_right,max_left));
        }
        return Math.max(max_right,max_left);
    }
}
