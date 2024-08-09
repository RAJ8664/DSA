public class print_all_subsequences_of_string {
    static HashMap<String, ArrayList<String>> memo;
    static HashSet<String> set;
    static int dp[][];
    public ArrayList<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        set = new HashSet<>();
        memo = new HashMap<>();
        
        dp = new int[n + 1][m + 1];
        fill_dp_table(s, t);
        
        solve(n , m , s, t, "");
        
        ArrayList<String> res = new ArrayArrayList<>();
        for (String x : set) res.add(x);
        Collections.sort(res);
        return res;
    }
    
    static void solve(int i, int j, String s, String t, String current) {
        if (i < 1 || j < 1) {
            StringBuilder sb = new StringBuilder(current);
            String x = sb.reverse().toString();
            set.add(x);
            return;
        }
        
        String key = i + ":" + j + ":" + current;
        if (memo.containsKey(key)) {
            set.addAll(memo.get(key));
            return;
        }
        
        if (s.charAt(i - 1) == t.charAt(j - 1)) solve(i - 1, j - 1, s, t, current + s.charAt(i - 1));
        else {
            if (dp[i - 1][j] > dp[i][j - 1]) solve(i - 1, j, s, t, current);
            else if (dp[i][j - 1] > dp[i - 1][j]) solve(i, j - 1, s, t, current);
            else if (dp[i][j - 1] == dp[i - 1][j]) {
                solve(i - 1, j , s, t, current);
                solve(i , j - 1, s, t, current);
            }
        }
        
        ArrayList<String> to_put = new ArrayArrayList<>(set);
        memo.put(key, to_put);
    }
    
    static void fill_dp_table(String s, String t) {
        int n = s.length();
        int m = t.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
    }
}