class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 1;
        long high = (int)(1e5);
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (ok(mid, neededApples)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        System.out.println(ans);
        return ans * 8;
    }

    private static boolean ok(long mid, long need) {
       long total = 2L * mid * (2L * mid * mid + 3L * mid + 1);
       return total >= need;
    }
}