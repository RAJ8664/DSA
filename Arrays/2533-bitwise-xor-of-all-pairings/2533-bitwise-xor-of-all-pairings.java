class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums1) map.put(ele, map.getOrDefault(ele, 0) + nums2.length);
        for (int ele : nums2) map.put(ele, map.getOrDefault(ele, 0) + nums1.length);
        int res = 0;
        for (Map.Entry<Integer, Integer> curr : map.entrySet()) if (curr.getValue() % 2 == 1) res ^= curr.getKey();
        return res;
    }
}