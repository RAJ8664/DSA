package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number_of_island {
    static class Pair{
        int first;
        int second;
        public Pair(int first , int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char grid[][] = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int ans = NumberOfIsland(grid);
        System.out.println(ans);
    }

    public static int NumberOfIsland(char grid[][]) {
        int row = grid.length;
        int col = grid[0].length;
        int visited[][] = new int[row + 1][col + 1];
        for(int[] temp : visited) {
            Arrays.fill(temp, 0);
        }

        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j , grid,visited);
                }
            }
        }
        return count;
    }

    public static void bfs(int row, int col, char grid[][], int vis[][]) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        //change the direction according to the given condition , here in the question it was about all eight direction;
        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0, 1} , {-1, 1} , {-1, -1} , {1, -1} , {1, 1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while(!q.isEmpty()) {
            int cr = q.peek().first;
            int cc = q.peek().second;
            q.poll();
            for(int dire[] : dir) {
                int nrow = cr + dire[0];
                int ncol = cc + dire[1];
                if(nrow < n && nrow >=0 && ncol < m && ncol >= 0 && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
