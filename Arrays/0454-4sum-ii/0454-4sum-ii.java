class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele1 : nums3) {
            for (int ele2 : nums4) {
                map.put((ele1 + ele2) , map.getOrDefault(ele1 + ele2 , 0) + 1);
            } 
        }
        for (int ele1 : nums1) {
            for (int ele2 : nums2) {
                int req = 0 - (ele1 + ele2);
                count += map.getOrDefault(req, 0);
            }
        }
        return count;
    }
}
