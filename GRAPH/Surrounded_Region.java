package GRAPH;

import java.util.Scanner;

public class Surrounded_Region {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char mat[][] = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                mat[i][j] = s.charAt(j);
            }
        }


        int vis[][] = new int[n + 1][m + 1];
        char ans[][] = new char[n][m];
        //first row;
        for(int j = 0; j < m; j++) {
           if(vis[0][j] == 0 && mat[0][j] == 'O') dfs(0,j, mat,vis);
        }

        //first column;
        for(int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && mat[i][0] == 'O') dfs(i,0,mat,vis);
        }

        //last colum;
        for(int i = 0; i < n; i++) {
            if(vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') dfs(i,m - 1, mat, vis);
        }


        //last row;
        for(int j = 0; j < m; j++) {
            if(vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') dfs(n - 1, j,mat,vis);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 'X') ans[i][j] = 'X';
                else if(vis[i][j] == 1) ans[i][j] = 'O';
                else ans[i][j] = 'X';
            }

        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int row, int col, char mat[][],int vis[][]) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;
        int dir[][] = {{-1, 0} , {1, 0} , {0 , -1} , {0, 1}};
        for(int dire[] : dir) {
            int nrow = row + dire[0];
            int ncol = col + dire[1];
            if(ncol >= 0 && nrow >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, mat,vis);

            }
        }
    }
}
