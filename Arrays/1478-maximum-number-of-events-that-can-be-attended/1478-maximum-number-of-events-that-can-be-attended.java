import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "Pair{" +
                   "start=" + start +
                   ", end=" + end +
                   '}';
        }
    }
    static class customSort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(first.start, second.start);
            if (op1 != 0)
                return op1;
            return Integer.compare(first.end, second.end);
        }
    }
    public int maxEvents(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        ArrayList<Pair> events = new ArrayList<>();
        for (int current[] : arr)
            events.add(new Pair(current[0], current[1]));
        Collections.sort(events, new customSort());

        int currentIdx = 0, count = 0, currentDay = 1, lastDay = 0;
        for (Pair e : events)
            lastDay = Math.max(lastDay, e.end);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (currentDay <= lastDay) {
            while (currentIdx < n && events.get(currentIdx).start <= currentDay) {
                pq.offer(events.get(currentIdx).end);
                currentIdx++;
            }
            while (pq.size() > 0 && pq.peek() < currentDay)
                pq.poll();
            if (pq.size() > 0) {
                count++;
                pq.poll();
            }
            currentDay++;
        }
        return count;
    }
}