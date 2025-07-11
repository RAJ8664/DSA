class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (int i = 0; i < n; i++) {
            int current_ele = nums[i];
            if (map.containsKey(current_ele)) {
                int req = k - current_ele;
                if (current_ele == req) {
                    if (map.containsKey(current_ele) && map.getOrDefault(current_ele, 0) > 1) {
                        count++;
                        map.put(req, map.getOrDefault(req, 0) -1);
                        map.put(current_ele, map.getOrDefault(current_ele, 0) -1);
                        if (map.getOrDefault(req, 0) == 0) map.remove(req);
                        if (map.getOrDefault(current_ele, 0) == 0) map.remove(current_ele);
                    }
                }
                else if (map.containsKey(req)) {
                    count++;
                    map.put(req, map.getOrDefault(req, 0) -1);
                    map.put(current_ele, map.getOrDefault(current_ele, 0) -1);
                    if (map.getOrDefault(req, 0) == 0) map.remove(req);
                    if (map.getOrDefault(current_ele, 0) == 0) map.remove(current_ele);
                }
            }
        }
        return count;
    }
}