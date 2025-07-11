class Solution {
    static class custom_sort implements Comparator<String> {
        @Override
        public int compare(String first , String second) {
            return Integer.compare(first.length() , second.length());
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        List<String> res = new ArrayList<>();
        Arrays.sort(folder, new custom_sort());
        int vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) continue;
            res.add(folder[i]);
            vis[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (check(folder[i] , folder[j])) vis[j] = 1;
            }
        }
        return res;
    }

    private boolean check(String first, String second) {
        int n = first.length();
        int m = second.length();
        if (n == m) {
            if (second.startsWith(first)) return true;
        }
        for (int i = 0; i < Math.min(n , m); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        if (second.charAt(n) == '/') return true;
        return false;
    }
}