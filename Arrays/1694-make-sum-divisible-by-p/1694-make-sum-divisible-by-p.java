class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        nums[0] %= p;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            nums[i] %= p;            
        }
        int rem = nums[nums.length - 1];
        if (rem == 0) return 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {  
            int curRem = (nums[i] - rem + p) % p;
            if (map.containsKey(curRem)) {  
                int ids = map.get(curRem);
                res = Math.min(res, i - ids);
                if (res == 1) return 1;
            }
            map.put(nums[i], i);  
        }
        if (res == n) return -1;
        return res;
    }
}