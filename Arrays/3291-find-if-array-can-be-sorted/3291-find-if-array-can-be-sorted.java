class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            int  current = nums[i];
            int j = i;
            while(j - 1 >= 0 && nums[j] < nums[j - 1]) {
                int first = count(nums[j]);
                int second = count(nums[j - 1]);
                if(first != second){
                    flag = false;
                    break;
                }
                else {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                j--;
            }
        }
        return flag;
    }
    
    
    private static int count(int n) { 
        if (n == 0) return 0;
        return (n & 1) + count(n >> 1);
    }
}