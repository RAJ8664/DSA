class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) board[i][j] = '.';
        }
        List<List<String>> res = new ArrayList<>();
        solve(board, 0, res);
        return res;
    }
    private static void solve(char board[][] , int current_row, List<List<String>> res) {
        if(current_row == board.length) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                String current = "";
                for(int j = 0; j < board.length; j++) current += board[i][j];
                temp.add(current);
            }
            res.add(new ArrayList<>(temp));
            return;  
        }
        for(int j = 0; j < board.length; j++) {
            if(check(current_row, j , board)) {
                board[current_row][j] = 'Q';
                solve(board, current_row + 1, res);
                board[current_row][j] = '.';
            }
        }
    }
    private static boolean check(int row, int col, char board[][]) {
        int n = board.length;
        for(int j = 0; j < n; j++) if(board[row][j] == 'Q') return false;
        for(int i = 0; i < n; i++) if(board[i][col] == 'Q') return false;
        int cr = row, cc = col;
        while(cr < n && cc < n) {
            if(board[cr][cc] == 'Q') return false;
            cr++;
            cc++;
        }
        cr = row; cc = col;
        while(cr < n && cc >= 0) {
            if(board[cr][cc] == 'Q') return false;
            cr++;
            cc--;
        }
        cr = row; cc = col;
        while(cr >= 0 && cc < n) {
            if(board[cr][cc] == 'Q') return false;
            cr--;
            cc++;
        }
        cr = row; cc = col;
        while(cr >= 0 && cc >= 0) {
            if(board[cr][cc] == 'Q') return false;
            cr--;
            cc--;
        }
        return true;  
    }
}