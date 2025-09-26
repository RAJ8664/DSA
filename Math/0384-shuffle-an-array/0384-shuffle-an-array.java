class Solution {
    private int original[];
    private int shuffled[];
    public Solution(int[] nums) {
        original = new int[nums.length];
        shuffled = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
            shuffled[i] = nums[i];
        }
    }
    public int[] reset() {
        return original;
    }
    public int[] shuffle() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int ele : shuffled) temp.add(ele);
        Collections.shuffle(temp);
        for (int i = 0; i < temp.size(); i++) shuffled[i] = temp.get(i);
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
