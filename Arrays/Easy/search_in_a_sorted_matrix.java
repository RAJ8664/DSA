public class search_in_a_sorted_matrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};

        System.out.println(brute_force(arr,5));
        System.out.println(better_approach(arr,5));
        System.out.println(optimal_approach(arr,5));

    }
    public static boolean brute_force(int[][] arr,int target){
        int n=arr.length; //number of rows;
        int m=arr[0].length; //number of columns;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
        //TC=O(n*m);
        //SC=)(1);

    }

    public static boolean better_approach(int[][] arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        int i=0;
        int j=m-1;
        while(i<n&&j>=0){
            if(arr[i][j]>target){
                j--;
            }
            else if(arr[i][j]<target){
                i++;
            }
            else if(arr[i][j]==target){
                return true;
            }
        }
        return false;
        //TC=O(m+n);
        //SC=O(1);
    }

    /*
    * optimal approach is applicable when input matrix is sorted rowise as well as column wise and then first
    * element of next row is greater than last element of previous row;
    *
    * Example : [   [1,3,5,7],
                    [10,11,16,20],
                    [23,30,34,60]   ]

    * */
    public static boolean optimal_approach(int[][] arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        int low=0;
        int high=n*m-1;
        while(low<=high){
            int mid=(low+high)/2;
            //m=number of column;
            //mid/m=index of row;
            //mid%m=index of column;
            if(arr[mid/m][mid%m]==target){
                return true;
            }
            else if(arr[mid/m][mid%m]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
        //TC=O(log(m*n));
        //SC=O(1);
    }
}
