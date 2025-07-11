class Solution {
    static class Pair {
        int ind, count, node;
        public Pair(int ind, int count, int node) {
            this.ind = ind;
            this.count = count;
            this.node = node;
        }
        @Override
        public String toString() {
            return "(" + ind + " " + count + " " + node + ")";
        }
    }
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        Stack<Pair> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = nums[i];
            int count = 0;
            while (st.size() > 0 && current > st.peek().node) {
                count = Math.max(count + 1, st.peek().count);
                st.pop();
            }
            st.add(new Pair(i, count, current));
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}