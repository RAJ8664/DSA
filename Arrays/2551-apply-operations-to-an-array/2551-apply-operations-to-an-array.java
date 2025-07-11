class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        shift(nums);
        return nums;
    }
    private void shift(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int ele : arr) if (ele != 0) res.add(ele);
        for (int ele : arr) if (ele == 0) res.add(ele);
        for (int i = 0; i < n; i++) arr[i] = res.get(i);
    }
}