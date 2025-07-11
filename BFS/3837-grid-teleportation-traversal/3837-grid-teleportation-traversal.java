import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
    private HashMap<Character, ArrayList<Pair >> map;
    static class State {
        int row, col, move;
        int freq[];
        public State(int row, int col, int move, int[] freq) {
            this.row = row;
            this.col = col;
            this.move = move;
            this.freq = freq;
        }
    }
    static class customSort implements Comparator<State> {
        @Override
        public int compare(State first, State second) {
            return Integer.compare(first.move, second.move);
        }
    }
    static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair)o;
                return p.row == row && p.col == col;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    public int minMoves(String[] matrix) {
        int n = matrix.length, m = matrix[0].length();
        map = new HashMap<>();
        char arr[][] = new char[n][matrix[0].length()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                arr[i][j] = matrix[i].charAt(j);
                if (!map.containsKey(arr[i][j]))
                    map.put(arr[i][j], new ArrayList<>());
                map.get(arr[i][j]).add(new Pair(i, j));
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>(new customSort());
        pq.offer(new State(0, 0, 0, new int[26]));
        int dist[][] = new int[n][m];
        for (int current[] : dist)
            Arrays.fill(current, (int)(1e9));
        dist[0][0] = 0;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (pq.size() > 0) {
            int currRow = pq.peek().row, currCol = pq.peek().col, currMove = pq.peek().move;
            int currFreq[] = pq.peek().freq;
            pq.poll();

            if (arr[currRow][currCol] != '.') {
                if (currFreq[arr[currRow][currCol] - 'A'] == 0) {
                    int newFreq[] = new int[26];
                    newFreq = currFreq;
                    newFreq[arr[currRow][currCol] - 'A'] = 1;
                    ArrayList<Pair> cells = new ArrayList<>();
                    cells = map.get(arr[currRow][currCol]);
                    for (Pair x : cells) {
                        if (dist[x.row][x.col] > currMove) {
                            dist[x.row][x.col] = currMove;
                            pq.offer(new State(x.row, x.col, currMove, newFreq));
                        }
                    }
                }
            }

            for (int dire[] : dir) {
                int newRow = currRow + dire[0], newCol = currCol + dire[1];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || arr[newRow][newCol] == '#')
                    continue;
                if (dist[newRow][newCol] > currMove + 1) {
                    dist[newRow][newCol] = currMove + 1;
                    pq.offer(new State(newRow, newCol, currMove + 1, currFreq));
                }
            }
        }
        if (dist[n - 1][m - 1] == (int)(1e9))
            return -1;
        return dist[n - 1][m - 1];
    }
}