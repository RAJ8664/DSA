class Solution {
    public int subsetXORSum(int[] nums) {
        int ans[] = new int[1];
        solve(0, nums, new ArrayList<>(), ans);
        return ans[0];
    }
    public static void solve(int ind, int arr[], ArrayList<Integer> temp,int ans[]) {
        if(ind > arr.length - 1) {
            int res = 0;
            for(int i = 0; i < temp.size(); i++) {
                res ^= temp.get(i);
            }
            ans[0] += res;
            return;
        }
        temp.add(arr[ind]);
        solve(ind + 1, arr, temp, ans);
        temp.remove(temp.size() - 1);
        solve(ind + 1 ,arr, temp, ans);
    }
}