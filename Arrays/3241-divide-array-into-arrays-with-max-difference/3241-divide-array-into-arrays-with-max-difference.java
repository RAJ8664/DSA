class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int ans[][] = new int[n / 3][3];
        if (n % 3 != 0)
            return ans;
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i < n) {
            if(temp.size() == 3) {
                res.add(new ArrayList<>(temp));
                temp.clear();
            }
            else 
                temp.add(nums[i++]);
        }
        if(temp.size() == 3) 
            res.add(new ArrayList<>(temp));        
        for(int l = 0; l < res.size(); l++) {
            for(int j = 0; j < res.get(l).size(); j++) 
                ans[l][j] = res.get(l).get(j);
        }
        boolean found = false;
        for(ArrayList<Integer> current : res) {
            int first = current.get(0), second = current.get(1), third = current.get(2);
            if(Math.abs(first - second) <= k && Math.abs(second - third) <= k && Math.abs(first - third) <= k) 
                continue;
            else 
                found = true;
            if (found == true)
                break;
        }
        if(found) 
            return new int[][]{};
        return ans;
    }
}