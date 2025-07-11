import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[] suff = new int[n];
        suff[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; --i) {
            suff[i] = Math.max(events[i][2], suff[i + 1]);
        }
        int maxi = 0;
        for (int i = 0; i < n; ++i) {
            int left = i + 1, right = n - 1;
            int ind = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    ind = mid;
                    right = mid - 1;
                }
                else left = mid + 1;
            }
            
            if (ind != -1) maxi = Math.max(maxi, events[i][2] + suff[ind]);
            maxi = Math.max(maxi, events[i][2]);
        }
        return maxi;
    }
}