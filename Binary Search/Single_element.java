public class Single_element {
    //it is know that there is a single element that occurs once and other occurs twice, find that element;

    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(binary_search(arr));
    }

    public static int binary_search(int[] arr){
        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        if(arr[0]!=arr[1]){
            return arr[0];
        }
        if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]!=arr[mid+1]&&arr[mid]!=arr[mid-1]){
                return arr[mid];
            }
            else if(mid%2==0&&arr[mid]==arr[mid+1]||mid%2!=0&&arr[mid]==arr[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        //TC=O(logn);
        //SC=O(1);
    }

}
