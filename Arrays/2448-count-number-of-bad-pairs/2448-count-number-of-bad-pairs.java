class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int req = i - nums[i];
            count += res.size();
            count -= map.getOrDefault(req, 0);
            res.add(req);
            map.put(req, map.getOrDefault(req, 0) + 1);
        }
        return count;
    }
}