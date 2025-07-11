class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prod = nums[i] * nums[j];
                count += 8 * map.getOrDefault(prod, 0);
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        return count;
    }
}