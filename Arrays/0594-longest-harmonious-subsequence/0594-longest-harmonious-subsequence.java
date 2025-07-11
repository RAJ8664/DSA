class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> current = map.get(nums[i] + 1);
            if (current != null && current.size() > 0) {
                maxi = Math.max(maxi, current.last() - i + 1);
            }
        }
        return maxi;
    }
}