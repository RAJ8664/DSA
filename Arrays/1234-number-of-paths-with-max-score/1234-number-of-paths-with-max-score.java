import java.util.Arrays;
import java.util.List;

class Solution {
    private int sum[][];
    private int ways[][];
    private int mod = (int)(1e9 + 7);
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        char matrix[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                matrix[i][j] = board.get(i).charAt(j);
        }
        matrix[0][0] = '0';
        matrix[n - 1][m - 1] = '0';
        sum = new int[n + 1][m + 1];
        ways = new int[n + 1][m + 1];

        for (int current[] : sum)
            Arrays.fill(current, Integer.MIN_VALUE / 10);
        int dir[][] = {{0, -1}, {-1, 0}, {-1, -1}};

        sum[n - 1][m - 1] = 0;
        ways[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 'X')
                    continue;
                for (int dire[] : dir) {
                    int newRow = i + dire[0], newCol = j + dire[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] != 'X') {
                        int newSum = sum[i][j] + matrix[newRow][newCol] - '0';
                        if (newSum > sum[newRow][newCol]) {
                            sum[newRow][newCol] = newSum;
                            ways[newRow][newCol] = ways[i][j];
                        } else if (newSum == sum[newRow][newCol])
                            ways[newRow][newCol] = (ways[newRow][newCol] + ways[i][j]) % mod;
                    }
                }
            }
        }
        if (ways[0][0] == 0)
            return new int[] {0, 0};
        return new int[] {sum[0][0], ways[0][0]};
    }
}