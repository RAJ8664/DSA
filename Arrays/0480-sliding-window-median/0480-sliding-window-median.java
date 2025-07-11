class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(nums[a] != nums[b]) return Integer.compare(nums[a), nums[b]);
                else return a - b;
            }
        };
        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> minSet = new TreeSet<>(comparator);
        double res[] = new double[n - k + 1];
        int current_idx = 0;
        for (int i = 0; i < k; i++) {
            maxSet.add(i);
            minSet.add(maxSet.pollFirst());
            if (minSet.size() > maxSet.size()) maxSet.add(minSet.pollFirst());
        }
        res[current_idx++] = getMedian(minSet, maxSet, nums);
        int start = 0;
        for (int i = k; i < n; i++) {
            if (minSet.contains(start)) minSet.remove(start);
            if (maxSet.contains(start)) maxSet.remove(start);
            start++;
            maxSet.add(i);
            minSet.add(maxSet.pollFirst());
            if (minSet.size() > maxSet.size()) maxSet.add(minSet.pollFirst());
            res[current_idx++] = getMedian(minSet, maxSet, nums);
        }
        return res;
    }
    private double getMedian(TreeSet<Integer> minSet, TreeSet<Integer> maxSet, int nums[]) {
        if (minSet.size() == maxSet.size()) {
            double current_res = nums[maxSet.first()] * 1.0 + nums[minSet.first()] * 1.0;
            current_res = current_res / 2 * 1.0;
            return current_res;
        }
        return (double)(nums[maxSet.first()] * 1.0);
    }
}
