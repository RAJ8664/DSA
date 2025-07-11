class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(nums[i], i);
        for (int current[] : operations) {
            int l = current[0], r = current[1];
            int ind = map.get(l);
            map.remove(l);
            map.put(r, ind);
        }
        int res[] = new int[n];
        for (Map.Entry<Integer, Integer> curr: map.entrySet()) {
            int key = curr.getKey();
            int val = curr.getValue();
            res[val] = key;
        }
        return res;
    }
}