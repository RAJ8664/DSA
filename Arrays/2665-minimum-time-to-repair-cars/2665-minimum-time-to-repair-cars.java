class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long ans = -1, low = 1, high = (long)(1e15);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (ok(mid, ranks, cars)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    private boolean ok(long mid, int ranks[] , int cars) {
        int n = ranks.length;
        long count = 1, total = 0;
        for (int i = 0; i < n; i++) {
            long current = ranks[i];
            total += (long)(Math.sqrt(mid / current));
        }
        return total >= cars;
    }
}