class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length, count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            int current = nums[i];
            if (res.size() == 0) 
                res.add(current);
            else {
                int last = res.get(0), diff = Math.abs(last - current);
                if (diff > k) {
                    res.clear();
                    count++;
                    res.add(current);
                }
                else 
                    res.add(current);
            }
        }
        if (res.size() > 0) 
            count++;
        return count;
    }
}