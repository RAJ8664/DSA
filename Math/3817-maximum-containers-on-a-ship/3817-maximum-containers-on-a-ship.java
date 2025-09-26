class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        long weight = 0;
        int count = 0;
        for (int i = 0; i < n * n; i++) {
            weight += w;
            if (weight > maxWeight) break;
            count++;
        }
        return count;
    }
}