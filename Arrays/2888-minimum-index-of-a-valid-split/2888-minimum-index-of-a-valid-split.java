class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) map1.put(nums.get(i), map1.getOrDefault(nums.get(i), 0) + 1);
        for (int i = 0; i < n; i++) {
            int current = nums.get(i);
            map2.put(current, map2.getOrDefault(current, 0) + 1);
            map1.put(current, map1.getOrDefault(current, 0) - 1);
            if (map2.getOrDefault(current, 0) * 2 > i + 1 && map1.getOrDefault(current, 0) * 2 > n - i - 1) return i;
        }
        return -1;
    }
}