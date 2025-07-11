class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            if (map.containsKey(current * 2)) return true;
            if (current % 2 == 0 && map.containsKey(current / 2)) return true;
            map.put(current, i);
        }
        return false;
    }
}