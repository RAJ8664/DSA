class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String current = "";
            current += arr1[i];
            String to_put = "";
            for (int j = 0; j < current.length(); j++) {
                to_put += current.charAt(j);
                set.add(to_put);
            }
        }

        int maxi = 0;
        for (int i = 0; i < m; i++) {
            String current = "";
            current += arr2[i];
            String to_check = "";
            for (int j = 0; j < current.length(); j++) {
                to_check += current.charAt(j);
                if (set.contains(to_check)) maxi = Math.max(maxi, to_check.length());
            }
        }
        return maxi;
    }
}