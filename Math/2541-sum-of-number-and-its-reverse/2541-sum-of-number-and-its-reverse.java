class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num / 2; i <= num; i++) {
            if (i + get(i) == num) return true;
        }
        return false;
    }
    private int get(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}