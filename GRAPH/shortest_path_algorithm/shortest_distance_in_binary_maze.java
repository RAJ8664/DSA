package GRAPH.shortest_path_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class shortest_distance_in_binary_maze {
    //Read the problem statement on geeks for geeks;
    static class Pair {
        int row, col, distance;
        public Pair (int row, int col,int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int grid[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int source[] = new int[2];
        int destination[] = new int[2];
        for(int i = 0; i < 2; i++) source[i] = sc.nextInt();
        for(int i = 0; i < 2; i++) destination[i] = sc.nextInt();
        int res = shortestPath(grid,source,destination);
        System.out.println(res);
    }


    //Dijkstra algorithm approach;
    public static int shortestPathBinaryMatrix(int[][] matrix, int source[], int dest[]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dist[][] = new int[n + 1][m + 1];
        for (int current[] : dist) Arrays.fill(current, (int) (1e9));
        int sr = source[0];
        int sc = source[1];
        int dr = dest[0];
        int dc = dest[1];

        if (matrix[sr][sc] == 0 || matrix[dr][dc] == 0) return -1;
        dist[sr][sc] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc, 0));
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int cd = q.peek().distance;
            dist[cr][cc] = cd;
            q.poll();
            for (int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                int nd = cd + 1;
                if (nr < n && nc < m && nr >= 0 && nc >= 0 && matrix[nr][nc] == 1) {
                    if (dist[nr][nc] > cd + 1) {
                        dist[nr][nc] = cd + 1;
                        q.offer(new Pair(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
        if (dist[dr][dc] == (int) (1e9)) return -1;
        return dist[dr][dc];
    }


    //bfs approach
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n + 1][m + 1];
        for(int current[] : vis) Arrays.fill(current, 0);
        int sr = source[0];
        int sc = source[1];
        int dr = destination[0];
        int dc = destination[1];
        if(grid[dr][dc] == 0) return -1;

        //problem stated that you can move only to up , left , right , down;
        int dir[][]  = {{-1, 0} , {0, -1} , {0,  1} , {1, 0}};
        vis[sr][sc] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc,0));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int cd = q.peek().distance;
            q.poll();
            if(cr == dr && cc == dc) {
                min = Math.min(min, cd);
            }
            for(int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if(nr < n && nc < m && nr >= 0 && nc >= 0 && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    q.offer(new Pair(nr,nc, cd + 1));
                    vis[nr][nc] = 1;
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
