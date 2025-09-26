class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] arr = new int[10];
        for (int i = 0; i < digits.length; i++) arr[digits[i] - '0'] = i;
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (arr[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[arr[k]];
                    digits[arr[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}