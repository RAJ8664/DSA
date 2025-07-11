class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length, count = 0;
        Arrays.sort(ages);
        for (int i = 0; i < n / 2; i++) {
            int temp = ages[i];
            ages[i] = ages[n - 1 - i];
            ages[n - 1 - i] = temp;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = ages[i];
            int res = binarySearch(i, current, ages);
            if (!map.containsKey(current)) map.put(current, res);
        }
        for (int i = 0; i < n; i++) count += map.getOrDefault(ages[i], 0);
        return count;
    }
    private int binarySearch(int current_ind, int current, int ages[]) {
        int n = ages.length;
        int low = current_ind + 1, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ages[mid] <= current && ages[mid] > 0.5 * current + 7 && !(ages[mid] > 100 && current < 100)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        if (ans == -1) return 0;
        return ans - current_ind;
    }
}
