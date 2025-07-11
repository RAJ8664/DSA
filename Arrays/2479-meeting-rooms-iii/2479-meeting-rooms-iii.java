class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        long[] times = new long[n];
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < meetings.length; i++){
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];
            boolean planned = false;
            int idx = -1;
            long value = Long.MAX_VALUE;
            for(int j = 0; j < n; j++){
                if(times[j] < value){
                    value = times[j];
                    idx = j;
                }
                if(times[j] <= startTime){
                    ans[j]++;
                    times[j] = endTime; 
                    planned = true; 
                    break;
                }
            }
            if(!planned){
                ans[idx]++;
                times[idx] += endTime - startTime;
            }
        }
        int maxTimes = -1, maxRoomNo = -1;
        for(int k = 0; k < n; k++){
            if(maxTimes < ans[k]){
                maxTimes = ans[k];
                maxRoomNo = k;
            }
        }
        return maxRoomNo;
    }
}