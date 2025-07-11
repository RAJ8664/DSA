class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> (e1[0] == e2[0] ? e1[1]-e2[1] : e1[0]-e2[0]));
        return maxValue(events, 0, k, 0, new int[k + 1][events.length]);
    }
    private int maxValue(int[][] events, int index, int remainingEvents, int lastEventEndDay, int[][] dp) {
		if (index >= events.length || remainingEvents == 0)
            return 0;
        if (lastEventEndDay >= events[index][0])
            return maxValue(events, index+1, remainingEvents, lastEventEndDay, dp);
        if (dp[remainingEvents][index] != 0)
            return dp[remainingEvents][index];
         return dp[remainingEvents][index] = Math.max(
            maxValue(events, index+1, remainingEvents, lastEventEndDay, dp), 
            maxValue(events, index+1, remainingEvents-1, events[index][1], dp) + events[index][2]
        );
    }
}