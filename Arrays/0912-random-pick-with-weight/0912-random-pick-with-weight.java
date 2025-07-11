class Solution {
    private int len;
    private double[] probabilities;
    private Random random;
    public Solution(int[] w) {
        this.len = w.length;
        CustomRandom(w);
    }
    public int pickIndex() {
        double rand = random.nextDouble(); 
        int low = 0, high = probabilities.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (rand > probabilities[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private void CustomRandom(int[] w) {
        probabilities = new double[w.length];
        random = new Random();
        int totalSum = 0;
        for (int weight : w) totalSum += weight;
        probabilities[0] = (double) w[0] / totalSum;
        for (int i = 1; i < w.length; i++) probabilities[i] = probabilities[i - 1] + (double) w[i] / totalSum;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
