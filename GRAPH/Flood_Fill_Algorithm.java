package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Flood_Fill_Algorithm {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int color = sc.nextInt();
        int sr = sc.nextInt();
        int stc = sc.nextInt();
        int image[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                image[i][j] = sc.nextInt();
            }
        }

        int ans[][] = new int[row][col];
        int vis[][] = new int[row + 1][col + 1];
        for(int temp[] : vis) Arrays.fill(temp, 0);
        for(int temp[] : ans) Arrays.fill(temp,-1);
        ans[sr][stc] = color;
        bfs(sr,stc,image,color, vis,ans);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(ans[i][j] == -1) ans[i][j] = image[i][j];
            }
        }
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int row, int col, int image[][],int color,int vis[][] , int ans[][]) {
        int n = image.length;
        int m = image[0].length;
        //all the direction possible;
        int dir[][] = {{-1, 0} , {1, 0} , {0,-1} , {0 , 1}};
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        while(!q.isEmpty()) {
            int cr = q.peek().first;
            int cc = q.peek().second;
            q.poll();
            for(int dire[] : dir) {
                int nrow = cr + dire[0];
                int ncol = cc + dire[1];
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && vis[nrow][ncol] == 0 && image[nrow][ncol] == image[row][col]) {
                   q.add(new Pair(nrow, ncol));
                   vis[nrow][ncol] = 1;
                   ans[nrow][ncol] = color;
                }
            }
        }

    }
}
