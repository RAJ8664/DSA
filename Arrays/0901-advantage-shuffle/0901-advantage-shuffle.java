class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans[] = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums1) {
            set.add(ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int current_ele = nums2[i];
            Integer next = set.higher(current_ele);
            if (next != null) {
                ans[i] = next;
                map.put(next, map.getOrDefault(next, 0) -1);
                if (map.getOrDefault(next, 0) == 0) set.remove(next);
            }
            else {
                ans[i] = set.first();
                map.put(set.first(), map.getOrDefault(set.first(), 0) -1);
                if (map.getOrDefault(set.first(), 0) == 0) set.remove(set.first());
            }
        }
        return ans;
    }
}