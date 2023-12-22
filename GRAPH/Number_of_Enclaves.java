package GRAPH;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number_of_Enclaves {
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int vis[][] = new int[n][m];
        int count = 0;
        //first row
        for(int j = 0; j < m; j++) {
            if(vis[0][j] == 0 && mat[0][j] == 1) dfs(0,j,mat,vis);
        }

        //last row;
        for(int j = 0; j < m; j++) {
            if(vis[n - 1][j] == 0 && mat[n - 1][j] == 1) dfs(n - 1, j , mat,vis);
        }

        //first column;
        for(int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && mat[i][0] == 1) dfs(i,0, mat ,vis);
        }

        //last column;
        for(int i = 0; i < n; i++){
            if(vis[i][m - 1] == 0 && mat[i][m - 1] == 1) dfs(i , m - 1, mat, vis);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }
        System.out.println(count);
    }


    public static void dfs(int row, int col ,int mat[][],int vis[][]) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;
        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0 , 1}};
        for(int dire[] : dir) {
            int nrow = row + dire[0];
            int ncol = col + dire[1];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                dfs(nrow, ncol, mat, vis);
            }
        }
    }


    //using bfs
    public static void bfs(int row, int col, int mat[][],int vis[][]) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        int dir[][] = {{-1, 0}, {1, 0} , {0 , -1} , {0 , 1}};
        while(!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            q.poll();
            vis[cr][cc] = 1;
            for(int dire[] : dir) {
                int nrow = cr + dire[0];
                int ncol = cc + dire[1];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }

}
