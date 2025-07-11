class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] matrix = new int[m][n];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1)  que.add(new int[]{i, j});
                else matrix[i][j] = -1;
            }
        }
        int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int r = arr[0];
            int c = arr[1];
            for(int[] dir: directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] ==- 1){
                    matrix[nr][nc] = matrix[r][c] + 1;  
                    que.add(new int[]{nr, nc});      
                } 
            }
        }
        return matrix;
    }
}