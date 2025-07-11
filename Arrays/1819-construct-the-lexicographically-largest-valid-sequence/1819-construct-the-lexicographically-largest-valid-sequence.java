class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2 - 1];
        boolean[] visited = new boolean[n + 1];
        calc(0, ans, visited, n);
        return ans;
    }
    private boolean calc(int index, int[] ans, boolean[] visited, int n) {
        if (index == ans.length) return true;
        if (ans[index] != 0) return calc(index + 1, ans, visited, n);
        for (int i = n; i >= 1; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[index] = i;
            if (i == 1) {
                if (calc(index + 1, ans, visited, n)) return true;
            } 
            else if (index + i < ans.length && ans[index + i] == 0) {
                ans[i + index] = i;
                if (calc(index + 1, ans, visited, n)) return true;
                ans[index + i] = 0;
            }
            ans[index] = 0;
            visited[i] = false;
        }
        return false;
    }
}
