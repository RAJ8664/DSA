class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0, maxi = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
            while (st.size() > 0 && st.peek() > arr[i]) st.pop();
            st.add(maxi);
        }
        return st.size();
    }
}