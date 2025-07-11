class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == n * n) return map.get(p);
            for(int i = p + 1; i <= Math.min(p + 6, n * n); i++){
                int next = check(i, n);
                int row = next / n, col = next % n;
                int ns = board[row][col] == -1 ? i : board[row][col];
                if(!map.containsKey(ns)){
                    map.put(ns, map.get(p) + 1);
                    q.offer(ns);
                }
            }
        }
        return -1;
    }
     public static int check(int i, int n){
        int q = (i - 1) / n, r = (i - 1) % n;
        int row = n - 1 - q;
        int col = row % 2 != n % 2 ? r: n - 1 - r;
        return row * n + col;
    }
}