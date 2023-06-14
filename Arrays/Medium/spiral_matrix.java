import java.util.ArrayList;
import java.util.Arrays;
public class spiral_matrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(12,13,14,5)));
        matrix.add(new ArrayList<>(Arrays.asList(11,16,15,6)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 9, 8,  7)));
        ArrayList<Integer> ans=Spiral_matrix(matrix);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static ArrayList<Integer> Spiral_matrix(ArrayList<ArrayList<Integer>> matrix){
        ArrayList<Integer> ans=new ArrayList<>();
        int n=matrix.size();
        int m=matrix.get(0).size();
        int top=0;
        int left=0;
        int right=m-1;
        int bottom=n-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(matrix.get(top).get(i));
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(matrix.get(i).get(right));
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix.get(bottom).get(i));
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix.get(i).get(left));
                }
                left++;
            }
        }
        return ans;
        //TC=O(n*m);
        //SC=O(1);
    }
}
