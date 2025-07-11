class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, chargeTimes, runningCosts, budget)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    private boolean ok(int mid, int chargeTimes[], int runningCosts[], long budget) {
        int n = chargeTimes.length, start = 0;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        long current_sum = 0;
        for (int i = 0; i < mid; i++) {
            int current = chargeTimes[i];
            set.add(current);
            map.put(current, map.getOrDefault(current, 0) + 1);
            current_sum += runningCosts[i];
        }
        long current_budget = set.last() * 1L +  mid * 1L * current_sum;
        if (current_budget <= budget) return true;
        for (int i = mid; i < n; i++) {
            int current = chargeTimes[i];
            current_sum += runningCosts[i]; current_sum -= runningCosts[start];
            map.put(current, map.getOrDefault(current, 0) + 1);
            map.put(chargeTimes[start], map.getOrDefault(chargeTimes[start], 0) -1);
            set.add(current);
            if (map.getOrDefault(chargeTimes[start], 0) == 0) {
                map.remove(chargeTimes[start]);
                set.remove(chargeTimes[start]);
            }
            start++;
            current_budget = set.last() * 1L + mid * (current_sum);
            if (current_budget <= budget) return true;
        }
        return false;
    }
}