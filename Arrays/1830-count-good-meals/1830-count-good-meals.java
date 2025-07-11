import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private int mod = 1000000007;
    public int countPairs(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, pow2Count = 0;
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            if (arr[i] == 0) {
                count = (count + pow2Count) % mod;
                map.put(0, map.getOrDefault(0, 0) + 1);
                continue;
            }
            if (current > 0 && (current & (current - 1)) == 0) {
                pow2Count++;
                count = (count + map.getOrDefault(current, 0)) % mod;
                count = (count + map.getOrDefault(0, 0)) % mod;
            } else {
                /* Find the first number which is power of 2 and is greater than current */
                int mask = 1;
                while (mask < current)
                    mask = mask << 1;
                int req = mask - current;
                count = (count + map.getOrDefault(req, 0)) % mod;
            }
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return count;
    }
}