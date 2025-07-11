class Solution {
    static class Pair {
        int node;
        int ind;
        public Pair(int node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }
    static class sorting implements Comparator<Pair> {
        @Override
        public int compare(Pair first , Pair second) {
            int op1 = Integer.compare(first.node, second.node);
            if(op1 != 0) return op1;
            return Integer.compare(first.ind , second.ind);
        }
    }
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sorting());
        for(int i = 0; i < n; i++) pq.offer(new Pair(nums[i], i));
        HashSet<Integer> visited = new HashSet<>();
        long total = 0;
        while(pq.size() > 0) {
            Pair current = pq.poll();
            if(visited.contains(current.ind)) continue;
            total += current.node;
            visited.add(current.ind);
            if(current.ind -1 >= 0) visited.add(current.ind - 1);
            if(current.ind + 1 < n) visited.add(current.ind + 1);
        }
        return total;
    }
}