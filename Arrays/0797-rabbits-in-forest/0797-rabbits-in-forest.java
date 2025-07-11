class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        int freq[] = new int[1001];
        for (int i = 0; i < n; i++) freq[answers[i]]++;
        int total = 0, maxi = answers[0];
        for (int ele : answers) maxi = Math.max(maxi, ele);
        for (int i = 0; i <= maxi; i++) {
            if (freq[i] == 0) continue;
            int first = freq[i] / (i + 1);
            if (freq[i] % (i + 1) != 0) first++;
            total += first * (i + 1);
        }
        return total;
    }
}