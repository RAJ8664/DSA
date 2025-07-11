class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        HashSet<Long> set = new HashSet<>();
        ArrayList<Long> res = new ArrayList<>();
        for (int ele : nums) {
            if (!set.contains(ele)) {
                set.add((long)ele);
                res.add((long)ele);
            }
        }
        int maxi = -1;
        for (int i = 0; i < res.size(); i++) {
            long current = res.get(i);
            int count = 0;
            while (true) {
                if (set.contains(current)) {
                    count++;
                    current = current * 1L * current;
                }
                else break;
            }
            maxi = Math.max(maxi, count);
        }
        if (maxi == 1) return -1;
        return maxi;
        
    }
}