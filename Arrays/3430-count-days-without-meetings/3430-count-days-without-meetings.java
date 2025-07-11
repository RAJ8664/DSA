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
    static class sorting implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(first.start, second.start);
        }
    }
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        int m = meetings[0].length;
        ArrayList<Pair> res = new ArrayList<>();
        for(int current[] : meetings) {
            int start = current[0], end = current[1];
            res.add(new Pair(start, end));
        }
        Collections.sort(res, new sorting());
        int current = 1, total = 0;
        for(int i = 0; i < res.size(); i++) {
            if(i == 0) {
                if(res.get(i).start != 1) {
                    total += res.get(i).start - current;
                    current = res.get(i).end;
                    continue;
                }
            }
            int calc = res.get(i).start - current - 1;
            if(calc > 0) total += calc;
            current = Math.max(current, res.get(i).end);
        }
        if(days - current > 0) total += days - current;
        return total;
    }
}