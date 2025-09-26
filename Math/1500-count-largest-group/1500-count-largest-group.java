class Solution {
    public int countLargestGroup(int n) {
        int freq[] = new int[100];
        for (int i = 1; i <= n; i++) {
            freq[solve(i)]++;
        }
        int maxi = 0, count = 0;
        for (int ele : freq) maxi = Math.max(maxi, ele);
        for (int ele : freq) if (ele == maxi) count++;
        return count;
    }
    private int solve(int n) {
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }
}