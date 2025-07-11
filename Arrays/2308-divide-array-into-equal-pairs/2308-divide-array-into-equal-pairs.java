class Solution {
    public boolean divideArray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int freq[] = new int[501];
        for (int ele : nums) {
            set.add(ele);
            freq[ele]++;
        }
        for (int ele : set) {
            if (freq[ele] % 2 == 1) return false;
        }
        return true;
    }
}