class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = prices[i];
            while (st.size() > 0 && st.peek() > current) st.pop();
            if (st.size() == 0) res[i] = current;
            else res[i] = current - st.peek();
            st.add(current);
        }
        return res;
    }
}