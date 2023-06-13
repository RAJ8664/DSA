import java.util.*;
public class set_matrices_to_zero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        ArrayList<ArrayList<Integer>> ans=optmal_approach(matrix);
        for(ArrayList<Integer> row:ans){
            for(int element:row){
                System.out.print(element+" ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> bruteforce(ArrayList<ArrayList<Integer>> matrix){
        int n=matrix.size();
        int m=matrix.get(0).size();
        ArrayList<Integer> row=new ArrayList<>();
        ArrayList<Integer> col=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row.contains(i)||col.contains(j)){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
        //TC=O(n^3); ArrayList.contains takes O(n) time;
        //SC=O(n+m);
    }


    public static ArrayList<ArrayList<Integer>> optmal_approach(ArrayList<ArrayList<Integer>> matrix){
        int n=matrix.size();
        int m=matrix.get(0).size();
        boolean[] row=new boolean[n];
        boolean[] col=new boolean[m];
        for(int i=0;i<n;i++){
            row[i]=false;
        }
        for(int j=0;j<m;j++){
            col[j]=false;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==true||col[j]==true){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
        //TC=O(n*m);
        //SC=O(1);
    }
    
    
     /*   GFG problem;
    *Given a matrix of  size n x m. Your task is to make Zeroes,
    *that means in whole matrix when you find a zero,
    *convert its upper, lower, left, and right value to zero and make that element
    *the sum of the upper, lower, left and right value.
    *Do the following tasks according to the initial matrix.
    * 
    * problem link=https://practice.geeksforgeeks.org/problems/make-zeroes4042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=make-zeroes
    * */

    public static void gfg(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=0;
                if(arr[i][j]==0){
                    if(i-1>=0){
                        sum+=arr[i-1][j];
                        matrix[i-1][j]=0;
                    }
                    if(i+1<n){
                        sum+=arr[i+1][j];
                        matrix[i+1][j]=0;
                    }
                    if(j-1>=0){
                        sum+=arr[i][j-1];
                        matrix[i][j-1]=0;
                    }
                    if(j+1<m){
                        sum+=arr[i][j+1];
                        matrix[i][j+1]=0;
                    }
                    matrix[i][j]=sum;
                }
            }
        }
    } 
}
