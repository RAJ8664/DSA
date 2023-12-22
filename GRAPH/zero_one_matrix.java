package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class zero_one_matrix {
    static class Tuple {
        int row;
        int col;
        int dist;
        public Tuple(int row, int col ,int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }


    //Read the problem statement on leetcode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int mat[][] = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int ans[][] = new int[row][col];
        for(int temp[] : ans) {
            Arrays.fill(temp, 0);
        }

        Queue<Tuple> q = new LinkedList<>();
        int vis[][] = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Tuple(i, j,0));
                    vis[i][j] = 1;
                }
                else vis[i][j] = 0;
            }
        }

        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0 , 1}};
        int n = mat.length;
        int m = mat[0].length;
        while(!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int cd = q.peek().dist;
            q.poll();
            ans[cr][cc] = cd;
            for(int dire[] : dir) {
                int nrow = cr + dire[0];
                int ncol = cc + dire[1];
                int ndist = cd + 1;
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0) {
                    q.offer(new Tuple(nrow, ncol,ndist));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
