class Solution {
    private ArrayList<Pair> vertical_merged;
    private ArrayList<Pair> horizontal_merged;
    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "(" + start + " " + end + ")";
        }
    } 
    static class custom_sort implements Comparator<int[]> {
        @Override
        public int compare(int[] first, int[] second) {
            return Integer.compare(first[0], second[0]);
        }
    }
    public boolean checkValidCuts(int n, int[][] arr) {
        int len = arr.length;
        int varr[][] = new int[len][2];
        int harr[][] = new int[len][2];
        for (int i = 0; i < len; i++) {
            int vl = arr[i][0], vr = arr[i][2];
            int hl = arr[i][1], hr = arr[i][3];
            varr[i][0] = vl; varr[i][1] = Math.max(varr[i][1], vr);
            harr[i][0] = hl; harr[i][1] = Math.max(harr[i][1], hr);
        }
        
        Arrays.sort(varr, new custom_sort());
        Arrays.sort(harr, new custom_sort());

        vertical_merged = new ArrayList<>();
        horizontal_merged = new ArrayList<>();
        merge(varr, vertical_merged);
        merge(harr, horizontal_merged);

        if (vertical_merged.size() >= 3 || horizontal_merged.size() >= 3) return true;
        return false;
    }
    private void merge(int arr[][], ArrayList<Pair> res) {
        int n = arr.length;
        int left = 0, right = 0;
        while (left < n) {
            int mini = arr[left][0], maxi = arr[left][1];
            while (right < n && arr[right][0] < maxi) {
                maxi = Math.max(maxi, arr[right][1]);
                right++;
            }
            res.add(new Pair(mini, maxi));
            left = right;
        }
    }
}