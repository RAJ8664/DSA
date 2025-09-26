class Solution {
    private int isprime[];
    public boolean primeSubOperation(int[] nums) {
        isprime = new int[1001];
        sieve();
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                for (int j = 2; j < nums[i]; j++) {
                    if (isprime[j] == 1) {
                        if (nums[i] - j < nums[i + 1]) {
                            nums[i] -= j;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }

    private void sieve() {
        Arrays.fill(isprime, 1);
        isprime[0] = isprime[1] = 0;
        for (int i = 2; i <= 1000; i++) {
            if (isprime[i] == 1) {
                for (int j = i; j * i < 1000 + 1; j++) {
                    if (isprime[j * i] == 1) {
                        isprime[j * i] = 0;
                    }
                }
            }
        }
    }
}