class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int freq[] = new int[501];
        int maxi = -1;
        for (int ele : arr)
            freq[ele]++;
        for (int ele : arr)
            if (freq[ele] == ele)
                maxi = Math.max(maxi, ele);

        return maxi;
    }
}