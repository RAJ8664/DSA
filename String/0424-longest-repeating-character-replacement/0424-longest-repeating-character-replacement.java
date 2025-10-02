class Solution {
     public static int characterReplacement(String s, int k) {
        int n = s.length();
        ArrayList<ArrayList<Integer>> pos = new ArrayList<>();
        for (int i = 0; i <= 30; i++) pos.add(new ArrayList<>());
        for (int i = 0; i < n; i++) pos.get(s.charAt(i) - 'A').add(i);
        int low = 1, high = n, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, s, k, pos)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    private static boolean ok(int mid, String s, int k, ArrayList<ArrayList<Integer>> pos) {
        int n = s.length();
        int maxi = 0;
        for (int ch = 'A'; ch <= 'Z'; ch++) {
            if (pos.get(ch - 'A').size() == 0) continue;
            if (pos.get(ch - 'A').size() == 1) maxi = Math.max(maxi, k + 1);
            int current_k = k;
            ArrayList<Integer> temp = pos.get(ch - 'A');
            maxi = Math.max(maxi, solve(temp, k , s)); 
        }
        return maxi >= mid;
    }
    private static int solve(ArrayList<Integer> res, int k, String s) {
        int n = res.size();
        int left = 0 , right = 0;
        int current_maxi = 0, maxi = 0;
        while (left < n) {
            while (right + 1 < n && res.get(right + 1) - res.get(right) - 1 <= k) {
                k -= res.get(right + 1) - res.get(right) - 1;
                right++;
            }
            maxi = Math.max(maxi, Math.min(s.length() , res.get(right) - res.get(left) + 1 + k));
            left++;
            if (left - 1 >= 0 && left < n) k += res.get(left) - res.get(left - 1) - 1;
        }
        return maxi;
    }
}
