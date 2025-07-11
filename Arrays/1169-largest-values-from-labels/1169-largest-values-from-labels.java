class Solution {
    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return "(" + first + " " + second + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(second.first, first.first);
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        ArrayList<Pair> res = new ArrayList<>(); 
        for (int i = 0; i < n; i++) res.add(new Pair(values[i], labels[i]));
        Collections.sort(res, new custom_sort());
        int sum = 0, count = 0;
        int freq[] = new int[(int)(1e5 + 1)];
        for (int i = 0; i < n; i++) {
            if (count == numWanted) break;
            Pair current = res.get(i);
            if (freq[current.second] == useLimit) continue;
            sum += current.first;
            count++;
            freq[current.second]++;
        }
        return sum;
    }
}