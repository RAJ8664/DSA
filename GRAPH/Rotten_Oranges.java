package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rotten_Oranges {
    static class Tuple{
        int row;
        int col;
        int time;
        public Tuple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int mat[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int ans = bfs(mat);
        System.out.println(ans);

    }

    public static int bfs(int mat[][]) {
        int max = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        int dir[][] = {{-1, 0} ,{1, 0} , {0, -1} , {0, 1}};
        Queue<Tuple> q = new LinkedList<Tuple>();
        int vis[][] = new int[n+ 1][m + 1];
        for(int temp[] : vis) Arrays.fill(temp, 0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2) {
                    q.add(new Tuple(i , j , 0));
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int ct = q.peek().time;
            q.poll();
            max = Math.max(max, ct);
            for(int dire[] : dir) {
                int nrow = cr + dire[0];
                int ncol = cc + dire[1];
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    q.add(new Tuple(nrow, ncol , ct + 1));
                    vis[nrow][ncol] = 1;
                    mat[nrow][ncol] = 2;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    return -1;
                }
            }
        }
        if(max == Integer.MIN_VALUE) return 0;
        return max;
    }
}
