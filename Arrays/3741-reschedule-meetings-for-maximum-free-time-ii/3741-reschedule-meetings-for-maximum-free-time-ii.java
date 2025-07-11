class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int space[] = new int[n + 1];
        int right[] = new int[n + 1];
        for (int i = 0; i < n; i++) 
            if (i == 0) 
                space[i] = startTime[i];
            else 
                space[i] = startTime[i] - endTime[i - 1];
        space[n] = eventTime - endTime[endTime.length - 1];
        for (int i = n - 1; i >= 0; i--) 
            right[i] = Math.max(right[i + 1], space[i + 1]);
        int current = 0, res = 0;
        for (int i = 1; i <= n; i++) {
            int gap = endTime[i - 1] - startTime[i - 1];
            if (current >= gap || right[i] >= gap) 
                res = Math.max(res, space[i - 1] + gap + space[i]);
            res = Math.max(res, space[i - 1] + space[i]);
            current = Math.max(current, space[i - 1]);
        }
        return res;
    }
}