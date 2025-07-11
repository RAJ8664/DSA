class Solution {
    static class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        @Override
        public String toString() {
            return "(" + val + " " + index + ")";
        }
    }
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int current_state[] = new int[m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) current_state[j] = 0;
                else current_state[j]++;
            }
            res += find_sum_of_all_heights_of_histogram(current_state);
        }
        return res;
    }

    private int find_sum_of_all_heights_of_histogram(int arr[]) {
        int n = arr.length;
        Stack<Pair> st = new Stack<>();
        int prev_smallest[] = new int[n];
        int next_smallest[] = new int[n];

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            while (st.size() > 0 && st.peek().val >= current) st.pop();
            if (st.size() == 0) prev_smallest[i] = -1;
            else prev_smallest[i] = st.peek().index;
            st.add(new Pair(current, i));
        }
        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            while (st.size() > 0 && st.peek().val >= current) st.pop();
            if (st.size() == 0) next_smallest[i] = -1;
            else next_smallest[i] = st.peek().index;
            st.add(new Pair(current, i));
        }

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int next_smaller_index = next_smallest[i];
            int prev_smaller_index = prev_smallest[i];
            if (prev_smaller_index == -1) res[i] = current * (i + 1);
            else {
                res[i] = res[prev_smaller_index];
                res[i] += current * (i - prev_smaller_index);
            }
        }
        int total = 0;
        for (int ele : res) total += ele;
        return total;
    }
}