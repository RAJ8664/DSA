class Solution {
    public int maximumLength(String s) {
        char[] arr = s.toCharArray();
        int[][] map = new int[26][s.length()];
        int max = -1;
        int i = 0;
        while (i < arr.length) {
            int j = i;
            while (j < arr.length && arr[j] == arr[i]) j++;
            int cont = j - i;
            for (int k = 0; k < cont; k++) {
                  map[arr[i] - 'a'][k] += cont - k;
                  if (map[arr[i] - 'a'][k] > 2) max = Math.max(max, k + 1);
            }
            i = j;
        }
        return max;
    }
}