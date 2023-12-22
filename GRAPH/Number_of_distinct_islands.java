package GRAPH;

import java.util.*;

public class Number_of_distinct_islands{
     static class Pair{
        int row;
        int col;
        public Pair(int row, int col) {
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

        HashSet<ArrayList<ArrayList<Integer>>> res = new HashSet<>();
        int vis[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 1) continue;
                else if(mat[i][j] == 1) {
                    ArrayList<Pair> temp = new ArrayList<>();
                    temp = dfs(i, j , mat,vis,temp);
                    if(temp.size() == 0) continue;
                    int x = temp.get(0).row;
                    int y = temp.get(0).col;
                    ArrayList<ArrayList<Integer>> rr = new ArrayList<>();
                    ArrayList<Integer> zz = new ArrayList<>();
                   for(Pair p : temp) {
                       p.row = p.row - x;
                       p.col = p.col - y;
                       zz.add(p.row);
                       zz.add(p.col);
                       rr.add(zz);
                   }
                   res.add(rr);
                }
            }
        }
        System.out.println(res.size());
    }

    public static ArrayList<Pair> dfs(int row, int col,int mat[][] ,int vis[][], ArrayList<Pair> ans) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;
        ans.add(new Pair(row, col));
        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0 , 1}};
        for(int dire[] : dir) {
            int nrow = row + dire[0];
            int ncol = col + dire[1];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                dfs(nrow,ncol, mat,vis,ans);
            }
        }
        return ans;
    }
}
