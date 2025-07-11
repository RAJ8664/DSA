class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < n; j++) {
                temp.add(nums[j]);
                if (check(temp) == true) count++;
            }
        }
        return count;
    }
    private boolean check(ArrayList<Integer> res) {
        int n = res.size();
        if (n < 3) return false;
        int diff = res.get(1) - res.get(0);
        for (int i = 0; i < n - 1; i++) {
            int next = res.get(i + 1);
            int current = res.get(i);
            if (next - current != diff) return false;
        }
        return true;
    }
}