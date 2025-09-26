class Solution {
    public char kthCharacter(long k, int[] arr) {
        int res = 0, c = 0, idx = 0;
        k--;
        while (idx < arr.length && k > 0) {
            c += ((int)(k & 1) & arr[idx]);
            k >>= 1;
            idx++;
        }
        return (char)((c % 26) + 'a');
    }
}