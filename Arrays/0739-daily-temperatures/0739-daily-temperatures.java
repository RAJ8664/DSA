class Solution {
    static class Pair {
        int node, ind;
        public Pair(int node, int ind) {
            this.node = node;
            this.ind = ind;
        }
        @Override
        public String toString() {
            return "(" + node + " " + ind + ")";
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Pair> st = new Stack<>();
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int current_ele = temperatures[i];
            while (st.size() > 0 && st.peek().node <= current_ele) st.pop();
            if (st.size() == 0) ans[i] = 0;
            else ans[i] = st.peek().ind - i;
            st.add(new Pair(current_ele, i));
        }
        return ans;
    }
}