class Solution {
    public int reachNumber(int target) {
        if (target < 0) target = -1 * target;
        int res = 1, current_pos = 0;
        while (current_pos < target) current_pos += res++;
        while (((current_pos - target) & 1) > 0) current_pos += res++;
        return res - 1;
    }
}