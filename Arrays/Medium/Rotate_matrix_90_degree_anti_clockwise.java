public class Rotate_matrix_90_degree_anti_clockwise {
    public static void main(String[] args) {
        int[][] matrix={{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int n=matrix.length;
        int[][] arr=new int[n][n];
        arr=optimal_approach(matrix);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] bruteforce(int[][] matrix){
        int n=matrix.length;
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                arr[n-1-j][i]=matrix[i][j];
            }
        }
        return arr;
        //TC=O(n*n);
        //SC=O(n*n)

    }

    public static int[][] optimal_approach(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[n-1-j][i];
                matrix[n-1-j][i]=temp;
            }
        }
        return matrix;
        //TC=O(n*m);
        //SC=O(1);
    }
}
