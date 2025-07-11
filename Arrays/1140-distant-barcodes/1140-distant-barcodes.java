class Solution {
    static class Pair {
        int node, freq, used;
        public Pair(int node, int freq, int used) {
            this.node = node;
            this.freq = freq;
            this.used = used;
        }
        @Override
        public String toString() {
            return "(" + node + " " + freq + " " + used + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(second.freq, first.freq);
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom_sort());
        PriorityQueue<Pair> pq1 = new PriorityQueue<>(new custom_sort());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : barcodes) map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (Map.Entry<Integer, Integer> curr : map.entrySet()) {
            int key = curr.getKey();
            int val = curr.getValue();
            pq.offer(new Pair(key, val, 0));
        }
        int res[] = new int[n];
        int k = 0;
        while (pq.size() > 0) {
            int key = pq.peek().node;
            int freq = pq.peek().freq;
            int used = pq.peek().used;
            pq.poll();
            res[k++] = key;
            if (pq1.size() > 0) pq.offer(pq1.poll());
            if (freq - 1 > 0) pq1.offer(new Pair(key, freq - 1, 1));
        }
        return res;
    }
}
