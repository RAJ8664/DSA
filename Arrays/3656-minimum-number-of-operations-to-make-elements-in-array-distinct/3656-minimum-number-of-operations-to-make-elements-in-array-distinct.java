class Solution {
    private int freq[];
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int ele : nums) dq.addLast(ele);
        freq = new int[101];
        for (int ele : nums) freq[ele]++;
        int count = 0;
        while (true) {
            if (check() == true) break;
            if (dq.size() > 0) freq[dq.pollFirst()]--;
            if (dq.size() > 0) freq[dq.pollFirst()]--;
            if (dq.size() > 0) freq[dq.pollFirst()]--;
            count++;
        }
        return count;
    }
    private boolean check() {
        for (int i = 0; i <= 100; i++) {
            if (freq[i] > 1) return false;
        }
        return true;
    }
}