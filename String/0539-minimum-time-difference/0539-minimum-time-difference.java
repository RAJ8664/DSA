class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        Collections.sort(minutesList);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        int circularDiff = 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0);
        minDiff = Math.min(minDiff, circularDiff);
        return minDiff;
    }
}