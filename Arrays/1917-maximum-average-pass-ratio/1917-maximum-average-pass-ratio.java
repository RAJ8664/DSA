class Solution {
    static class Pair {
        double delta;
        double pass;
        double total;
        public Pair(double delta, double pass, double total) {
            this.delta = delta;
            this.pass = pass;
            this.total = total;
        }
    }
    static class sorting implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Double.compare(second.delta , first.delta);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sorting());
        for(int current[] : classes) {
            double pass = (double)current[0];
            double total = (double)current[1];
            double delta = (double)(pass + 1) / (double)(total + 1) - (double)(pass) / (double)(total);
            pq.offer(new Pair(delta, pass, total)); 
        }
        while(extraStudents > 0) {
            double pass = pq.peek().pass;
            double total = pq.peek().total;
            double delta = pq.peek().delta;
            pass++;
            total++;
            double newDelta = (double)(pass + 1) / (double)(total + 1) - (double)(pass) / (double)(total);
            pq.poll();
            pq.offer(new Pair(newDelta, pass, total));
            extraStudents--;
        }
        double ans = 0;
        int total = pq.size();
        while(!pq.isEmpty()) {
            ans += (double)pq.peek().pass / (double)pq.peek().total;
            pq.poll();
        }
        return (double)(ans / (double) total);
    }
}