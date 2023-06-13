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
}
