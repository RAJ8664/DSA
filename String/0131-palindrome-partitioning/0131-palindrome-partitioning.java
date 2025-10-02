class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        int n = s.length();
        res = new ArrayList<>();
        solve(0, s, new ArrayList<>());
        return res;
    }
    private void solve(int ind, String s, List<String> temp) {
        if (ind >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            String current = s.substring(ind, i + 1);
            if (is_pallindrome(current)) {
                temp.add(current);
                solve(i + 1, s, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean is_pallindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}