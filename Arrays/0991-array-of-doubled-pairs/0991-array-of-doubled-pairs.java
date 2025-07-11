class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (int ele : arr) {
            if (map.getOrDefault(ele, 0) == 0) continue;
            if (ele < 0 && ele % 2 != 0) return false;
            int y = 0;
            if (ele > 0) y = 2 * ele;
            else y = ele / 2;
            if (map.getOrDefault(y, 0) == 0) return false;
            map.put(ele, map.getOrDefault(ele, 0) -1);
            map.put(y, map.getOrDefault(y, 0) -1);
        }
        return true;
    }
}