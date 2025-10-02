class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(nums[i]);
        String ans = solve("", n, set);
        return ans;
    }
    public static String solve(String ans, int n, HashSet<String> set) {
        if(ans.length() == n) {
            if(!set.contains(ans)) return ans;
            return "";
        }
        String z = solve(ans + "0", n, set);
        if(z.length() > 0) return z;
        return solve(ans + "1", n, set);
    }
}