class Solution {
    private int flag;
    private Map<String, Boolean> memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, sum = 0;
        flag = 0;
        for (int ele : nums) sum += ele;
        if (sum % k != 0) return false;
        int target = sum / k;
        memo = new HashMap<>();
        Arrays.sort(nums);
        reverse(nums);
        return solve(0, 0, nums, new boolean[n], k, target);
    }
    private boolean solve(int curIndex, int curSum, int[] nums, boolean[] visited, int k, int target) {
        if (k == 1) return true; 
        String memoKey = curSum + "-" + k + "-" + java.util.Arrays.toString(visited);
        if (memo.containsKey(memoKey)) return memo.get(memoKey);
        if (curSum == target) {
            boolean result = solve(0, 0, nums, visited, k - 1, target);
            memo.put(memoKey, result);
            return result;
        }
        for (int i = curIndex; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (solve(i + 1, curSum + nums[i], nums, visited, k, target)) {
                    memo.put(memoKey, true);
                    return true;
                }
                visited[i] = false; 
            }
        }
        memo.put(memoKey, false);
        return false;
    }
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
