class Solution {
    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return "(" + first + " " + second + ")";
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair current = (Pair)(obj);
            return current.first == first && current.second == second;
        }
        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    public int numEquivDominoPairs(int[][] arr) {
        int n = arr.length;
        HashMap<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(new Pair(arr[i][0], arr[i][1]), map.getOrDefault(new Pair(arr[i][0], arr[i][1]), 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i][0], y = arr[i][1];
            if (x == y) {
                count += map.getOrDefault(new Pair(x, y), 0) - 1;
                if (map.getOrDefault(new Pair(x, y), 0) > 0) map.put(new Pair(x, y), map.getOrDefault(new Pair(x, y), 0) -1);
            }        
            else {
                count += map.getOrDefault(new Pair(x, y), 0) - 1;
                count += map.getOrDefault(new Pair(y, x), 0);
                if (map.getOrDefault(new Pair(x, y), 0) > 0) map.put(new Pair(x, y), map.getOrDefault(new Pair(x, y), 0) -1);
            }
        }
        return count;
    }
}