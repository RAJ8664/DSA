class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int q2[][] = new int[queries.length][3], ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            q2[i][0] = queries[i][0];
            q2[i][1] = queries[i][1];
            q2[i][2] = i;
        }
        int nums[][] = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; ++i) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(q2, (a, b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int index = nums.length - 1;
        for (int i = q2.length - 1; i >= 0; --i) {
            while (index >= 0 && nums[index][0] >= q2[i][0]) {
                insert(tm, nums[index][0], nums[index][1]);
                index--;
            }
            var entry = tm.ceilingEntry(q2[i][1]);
            if (entry == null) ans[q2[i][2]] = -1;
            else ans[q2[i][2]] = entry.getValue();
        }
        return ans;
    }

    private void insert(TreeMap<Integer, Integer> tm, int x, int y) {
        int sum = x + y;
        if (tm.containsKey(y) && tm.get(y) >= sum) return;
        Integer higher = tm.higherKey(y);
        if (higher != null && tm.get(higher) >= sum) return;
        Set<Integer> hs = new HashSet<>();
        Integer lower = tm.lowerKey(y);
        while (lower != null) {
            if (tm.get(lower) <= sum) hs.add(lower);
            else break;
            lower = tm.lowerKey(lower);
        }
        for (int i : hs) tm.remove(i);
        tm.put(y, sum);
    }
}