class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];
        char[] arr = s.toCharArray();
        for (char c: arr) count[c]++;
        int need = arr.length / 4;
        int left = 0, right = 0, min = arr.length;
        while (right <= arr.length) {
            if (count['Q'] > need || count['W'] > need || count['E'] > need || count['R'] > need) {
				if (right >= arr.length) break;
                char rightCh = arr[right];
                count[rightCh]--;
                right++;
                continue;
            }
            min = Math.min(min, right-left);
            if (min == 0) break;
            char leftCh = arr[left];
            count[leftCh]++;
            left++;
        }
        return min;
    }
}