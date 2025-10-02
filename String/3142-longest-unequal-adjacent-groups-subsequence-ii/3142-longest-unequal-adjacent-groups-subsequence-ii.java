class Solution {
    private List<String> ans;
    private int dp[][];
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        dp = new int[n + 1][n + 1];
        for (int current[] : dp) Arrays.fill(current, -1);
        int res = solve(0, -1, groups, words);
        build_answer(words, groups);
        return ans;
    }
    private int solve(int ind, int prev, int groups[], String words[]) {
        if (ind >= words.length) return 0;
        if (dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        if (prev == -1) {
            int op1 = Integer.MIN_VALUE / 10, op2 = Integer.MIN_VALUE / 10;
            op1 = 1 + solve(ind + 1, ind, groups, words);
            op2 = solve(ind + 1, prev, groups, words);
            return dp[ind][prev + 1] = Math.max(op1, op2);
        } 
        else {
            int op1 = Integer.MIN_VALUE / 10, op2 = Integer.MIN_VALUE / 10;
            if (check(words[ind], words[prev]) == 1 && groups[ind] != groups[prev]) {
                op1 = 1 + solve(ind + 1, ind, groups, words);
            }
            op2 = solve(ind + 1, prev, groups, words);
            return dp[ind][prev + 1] = Math.max(op1, op2);
        }
    }
    private void build_answer(String words[], int groups[]) {
        int n = words.length;
        ans = new ArrayList<>();
        int ind = 0, prev = -1;
        while (ind < n) {
            int take = -1, not_take = dp[ind + 1][prev + 1];
            if (prev == -1) {
                take = 1 + dp[ind + 1][ind + 1];
            }
            else if (groups[prev] != groups[ind] && check(words[prev], words[ind]) == 1) {
                take = 1 + dp[ind + 1][ind + 1];
            }
            if (take > not_take) {
                ans.add(words[ind]);
                prev = ind;
            }
            ind++;
        }
    }
    private int check(String s, String t) {
        if (s.length() != t.length()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) count++;
        }
        if (count == 1) return 1;
        return 0;
    }
}