class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) if(nums[i] < pivot) res.add(nums[i]);
        for(int i = 0; i < n; i++) if(nums[i] == pivot) res.add(pivot);
        for(int i = 0; i < n; i++) if(nums[i] > pivot) res.add(nums[i]);
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) ans[i] = res.get(i);
        return ans;   
    }
}