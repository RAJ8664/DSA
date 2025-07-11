class Solution {
    static class Pair {
        int ind;
        int ele;
        public Pair(int ind, int ele) {
            this.ind = ind;
            this.ele = ele;
        }
        @Override
        public String toString() {
            return "(" + ind + " " + ele + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 =  Integer.compare(first.ele, second.ele);
            if (op1 != 0) return op1;
            return Integer.compare(first.ind, second.ind);
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom_sort());
        for (int i = 0; i < n; i++) pq.offer(new Pair(i, nums[i]));
        while (k-->0) {
            Pair current = pq.poll();
            current.ele = current.ele * multiplier;
            pq.offer(current);
        }
        int res[] = new int[n];
        while (pq.size() > 0) {
            res[pq.peek().ind] = pq.peek().ele;
            pq.poll();
        }
        return res;
    }
}