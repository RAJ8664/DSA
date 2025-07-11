class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int freq[] = new int[n + 1];
        for (int ele : banned) if (ele <= n) freq[ele]++;
        int current_sum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (current_sum + i <= maxSum && freq[i] == 0) {
                current_sum += i;
                count++;
            }
        }
        return count;
    }
}