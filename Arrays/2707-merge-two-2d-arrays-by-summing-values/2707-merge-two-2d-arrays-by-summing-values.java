class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length;
        ArrayList<Integer> ids = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int current[] : nums1) {
            ids.add(current[0]);
            map.put(current[0], map.getOrDefault(current[0], 0) + current[1]);
        }
        for (int current[] : nums2) {
            if (!ids.contains(current[0])) {
                ids.add(current[0]);
            }
            map.put(current[0], map.getOrDefault(current[0], 0) + current[1]);
        }
        int res[][] = new int[ids.size()][2];
        Collections.sort(ids);
        int idx = 0;
        for (int ele : ids) {
            res[idx][0] = ele;
            res[idx][1] = map.getOrDefault(ele, 0);
            idx++;
        }
        return res;
    }
}