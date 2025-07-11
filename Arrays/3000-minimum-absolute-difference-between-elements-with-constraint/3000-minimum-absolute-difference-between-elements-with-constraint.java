class Solution {
    static class Pair {
        int node, ind;
        public Pair(int node, int ind) {
            this.node = node;
            this.ind = ind;
        }
        @Override
        public String toString() {
            return "(" + node + " " + ind + ")";
        }
    }
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int mini = Integer.MAX_VALUE;
        if (x == 0) return 0;
        Queue<Pair> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = nums.get(i);
            if (q.size() > 0 && Math.abs(q.peek().ind - i) >= x) set.add(q.poll().node);
            Integer ceil = set.ceiling(current);
            Integer floor = set.floor(current);
            if (ceil != null) mini = Math.min(mini, Math.abs(current - ceil));
            if (floor != null) mini = Math.min(mini, Math.abs(current - floor));
            q.offer(new Pair(current, i));
        }
        return mini;
    }
}