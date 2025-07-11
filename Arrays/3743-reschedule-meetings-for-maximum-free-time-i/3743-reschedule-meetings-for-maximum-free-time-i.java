
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int low = 0, high = (int)(1e9);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(eventTime, k, startTime, endTime, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else 
                high = mid - 1;
        }
        return Math.max(ans, 0);
    }

    private boolean check(int eventTime, int k, int startTime[], int endTime[], int mid) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(startTime[0]);
        for (int i = 1; i < startTime.length; i++) 
            res.add(startTime[i] - endTime[i - 1]);
        res.add(eventTime - endTime[startTime.length - 1]);
        int sum = 0;
        for (int i = 0; i < k + 1; i++) {
            sum += res.get(i);
        }
        int maxi = sum;
        for (int i = k + 1; i < res.size(); i++) {
            sum += res.get(i) - res.get(i - (k + 1));
            maxi = Math.max(maxi, sum);
        }
        return maxi >= mid;
    }
}