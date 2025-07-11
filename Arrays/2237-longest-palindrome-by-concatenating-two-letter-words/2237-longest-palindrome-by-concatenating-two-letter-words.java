class Solution {
    public int longestPalindrome(String[] arr) {
        int n = arr.length;
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String current = arr[i];
            if (current.charAt(0) == current.charAt(1)) {
                map.put(current, map.getOrDefault(current, 0) + 1);
                continue;
            }
            StringBuilder sb = new StringBuilder(current);
            sb.reverse();
            if (map.getOrDefault(sb.toString(), 0) > 0) {
                count += 4;
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) -1);
            }
            else map.put(current, map.getOrDefault(current, 0) + 1);
        }
        HashMap<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> curr : map.entrySet()) {
            String key = curr.getKey();
            if (key.charAt(0) == key.charAt(1)) {
                newMap.put(key, curr.getValue());
            }
        }
        int maxi = 0, odd = 0;
        for (Map.Entry<String, Integer> curr : newMap.entrySet()) {
            int val = curr.getValue();
            if (val % 2 == 0 && val != 0) count += val * 2;
            if (val % 2 == 1) {
                odd = 1;
                maxi = Math.max(maxi, val);
                count += (val - 1) * 2;
            }
        }
        if (odd > 0) count += 2;
        return count;
    }
}
