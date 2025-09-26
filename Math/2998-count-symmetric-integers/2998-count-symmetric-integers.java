class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (check(i)) count++;
        }
        return count;
    }
    private boolean check(int n) {
        int count = 0;
        int temp = n;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        if (count % 2 == 1) return false;

        int sum = 0;
        temp = n;
        
        count = count / 2;
        while (count > 0) {
            sum += temp % 10;
            temp = temp / 10;
            count--;
        }
        while (temp > 0) {
            sum -= temp % 10;
            temp = temp / 10;
        }
        return sum == 0;
    }
}