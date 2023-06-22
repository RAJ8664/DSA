import java.util.ArrayList;

public class N_QUEENS {
    public static void main(String[] args) {
        int n=4;
        ArrayList<ArrayList<String>> ans=optimal_generate(n);
        for(ArrayList<String> row:ans){
            for(String raj:row){
                System.out.print(raj+" ");
            }
            System.out.println();
        }


    }

    //below is the implementation of bruteforce approach;
    //TC=O(n!*n);
    //SC=O(n^2); we will optimise the space in the next approach;
    public static ArrayList<ArrayList<String>> bruteforce_generate(int n){
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        brute_force(board,0,ans,n);
        return ans;
    }
    public static void brute_force(char[][] board,int col,ArrayList<ArrayList<String>> ans,int n){
        if(col==n){
            ans.add(construct(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(is_safe(row,col,board,n)){
                board[row][col]='Q';
                brute_force(board,col+1,ans,n);
                board[row][col]='.';
            }
        }
    }

    public static ArrayList<String> construct(char[][] board){
        ArrayList<String> ans=new ArrayList<>();
        int n=board.length;
        for(int i=0;i<n;i++){
            String temp="";
            for(int j=0;j<n;j++){
                temp+=board[i][j];
            }
            ans.add(temp);
        }
        return ans;
    }
    public static boolean is_safe(int row,int col,char[][] board,int n){
        int drow=row;
        int dcol=col;
        while(row>=0&&col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        row=drow;
        col=dcol;
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        row=drow;
        col=dcol;
        while(row<n&&col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    //below is the implementation of optimized approach;
    public static ArrayList<ArrayList<String>> optimal_generate(int n){
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int[] leftrow=new int[n];
        int[] lowerdiagonal=new int[2*n-1];
        int[] upperdiagonal=new int[2*n-1];
        optimal_appraoch(board,0,ans,leftrow,upperdiagonal,lowerdiagonal,n);
        return ans;
    }

   public static void optimal_appraoch(char[][] board,int col,ArrayList<ArrayList<String>> ans,
                                       int[] leftrow,int[] upperdiagonal,int[] lowerdiagonal,int n){
        if(col==n){
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(leftrow[row]==0&&upperdiagonal[n-1+col-row]==0&&lowerdiagonal[row+col]==0){
                board[row][col]='Q';
                leftrow[row]=1;
                upperdiagonal[n-1+col-row]=1;
                lowerdiagonal[row+col]=1;
                optimal_appraoch(board,col+1,ans,leftrow,upperdiagonal,lowerdiagonal,n);
                board[row][col]='.';
                leftrow[row]=0;
                upperdiagonal[n-1+col-row]=0;
                lowerdiagonal[row+col]=0;
            }
        }
   }


   //gfg version;
    /*
    *proble link=https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1
    *
    *
    * */

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int[][] board=new int[n][n];
        int[] leftrow=new int[n];
        int[] upperdiagonal=new int[2*n-1];
        int[] lowerdiagonal=new int[2*n-1];
        ArrayList<Integer> temp=new ArrayList<>();
        solve_gfg(board,0,ans,temp,n,leftrow,upperdiagonal,lowerdiagonal);
        return ans;
    }
    public static void solve_gfg(int[][] board,int col,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int n,
                             int[] leftrow,int[] upperdiagonal,int[] lowerdiagonal ){
        if(col==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0;row<n;row++){
            if(leftrow[row]==0&&upperdiagonal[n-1+col-row]==0&&lowerdiagonal[row+col]==0){
                leftrow[row]=1;
                upperdiagonal[n-1+col-row]=1;
                lowerdiagonal[row+col]=1;
                temp.add(row+1);
                solve_gfg(board,col+1,ans,temp,n,leftrow,upperdiagonal,lowerdiagonal);
                temp.remove(temp.size()-1);
                leftrow[row]=0;
                lowerdiagonal[row+col]=0;
                upperdiagonal[n-1+col-row]=0;
            }
        }
    }
}
