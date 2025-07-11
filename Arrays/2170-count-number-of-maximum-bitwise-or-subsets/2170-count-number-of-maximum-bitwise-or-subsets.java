class Solution {
    private ArrayList<ArrayList<Integer>> res;
    public int countMaxOrSubsets(int[] nums) {
        res = new ArrayList<>();
        solve(0, nums, new ArrayList<>());
        int maxi = 0;
        for(ArrayList<Integer> current : res) {
            int res2 = 0;
            for(int ele : current) {
                res2 |= ele;
            }
            maxi = Math.max(maxi, res2);
        }
        
        int count = 0;
        for(ArrayList<Integer> current : res) {
            int res1 = 0;
            for(int ele : current) {
                res1 |= ele;
            }
            if(res1 == maxi) count++;
        }
        return count;
    }

    private void solve(int ind, int arr[], ArrayList<Integer> temp) {
        if(ind > arr.length - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[ind]);
        solve(ind + 1, arr, temp);
        temp.remove(temp.size() - 1);
        solve(ind + 1, arr, temp);
    }  
}