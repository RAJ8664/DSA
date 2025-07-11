class RLEIterator {
    private Deque<Pair> dq;
    static class Pair {
        int count, node;
        public Pair(int count, int node) {
            this.count = count;
            this.node = node;
        }
    }
    public RLEIterator(int[] encoding) {
        dq = new ArrayDeque<>();
        int idx = 0, n = encoding.length;
        while (idx < n) {
            dq.addLast(new Pair(encoding[idx], encoding[idx + 1]));
            idx += 2;
        }
    }
    public int next(int n) {
        int req = n;
        int last = -1;
        while (dq.size() > 0 && req > 0) {
            Pair current = dq.pollFirst();
            if (current.count > req) {
                dq.addFirst(new Pair(current.count - req, current.node));
                req = 0;
            }
            else {
                req -= current.count;
            }
            last = current.node;
        }
        if (req > 0) return -1;
        return last;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */