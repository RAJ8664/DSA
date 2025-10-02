class Solution {
    private ArrayList<String> res;
    public String getHappyString(int n, int k) {
        res = new ArrayList<>();
        solve(n, "");
        Collections.sort(res);
        if (res.size() < k) return "";
        return res.get(k - 1);
    }
    private void solve(int n, String current) {
        if (current.length() == n) {
            res.add(current);
            return;
        }
        if (current.length() == 0) {
            solve(n, current + "a");
            solve(n, current + "b");
            solve(n, current + "c");
        }
        else {
            if (current.charAt(current.length() - 1) == 'a') {
                solve(n, current + "b");
                solve(n, current + "c");
            }
            else if (current.charAt(current.length() - 1) == 'b') {
                solve(n, current + "a");
                solve(n, current + "c");
            }
            else if (current.charAt(current.length() - 1) == 'c') {
                solve(n, current + "a");
                solve(n, current + "b");
            }
        }
    }
}