class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int freq[] = new int[1001];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int current = time[i];
            for (int j = 60; j <= 1000; j += 60) if (j - current > 0) count += freq[j - current];
            freq[current]++;
        }
        return count;
    }
}