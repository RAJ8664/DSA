package GRAPH.shortest_path_algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Path_with_minimum_effort {
    //Read the problem statment on leetcode;
    static class Pair {
        int distance , row, col;
        public Pair (int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
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
        int res = path_with_minimu_effor(grid);
        System.out.println(res);
    }

    public static int path_with_minimu_effor(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{-1,0} , {1, 0} , {0, -1} , {0 ,1}};
        int dist[][] = new int[n + 1][m + 1];
        for(int current[] : dist) Arrays.fill(current, (int)(1e9));
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        pq.offer(new Pair(0 , 0 , 0));
        while(!pq.isEmpty()) {
            int cr = pq.peek().row;
            int cc = pq.peek().col;
            int cd = pq.peek().distance;
            pq.poll();
            if(cr == n -1 && cc == m - 1) return cd;
            for(int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int nd = Math.max(cd, Math.abs(grid[cr][cc] - grid[nr][nc]));
                    if(dist[nr][nc] > nd) {
                        dist[nr][nc] = nd;
                        pq.offer(new Pair(dist[nr][nc], nr, nc));
                    }
                }
            }
        }
        return -1;
     }
}
