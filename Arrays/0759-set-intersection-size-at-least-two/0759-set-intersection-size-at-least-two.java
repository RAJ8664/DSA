class Solution {
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
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(first.end, second.end);
            if (op1 != 0) return op1;
            return Integer.compare(second.start, first.start);
        }
    }
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        ArrayList<Pair> res = new ArrayList<>();
        for (int current[] : intervals) {
            int start = current[0], end = current[1];
            res.add(new Pair(start, end));
        }   
        Collections.sort(res, new custom_sort());
        int last = res.get(0).end, slast = res.get(0).end - 1, set_size = 2;
        for (int i = 1; i < n; i++) {
            int current_start = res.get(i).start;
            int current_end = res.get(i).end;
            if (last >= current_start && slast >= current_start) continue;
            if (last >= current_start) {
                slast = last;
                last = current_end;
                set_size++;
            }
            else {
                last = current_end;
                slast = current_end - 1;
                set_size += 2;
            }
        }
        return set_size;
    }
}