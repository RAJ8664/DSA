class MKAverage {
    private TreeMap<Integer, Integer> map;
    private Deque<Integer> dq;
    int m, k, sum;
    public MKAverage(int m, int k) {
        map = new TreeMap<>();
        dq = new ArrayDeque<>();
        this.m = m;
        this.k = k;
        sum = 0;
    }
    public void addElement(int num) {
        dq.addLast(num);
        sum += num;
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (dq.size() > m) {
            int to_remove = dq.pollFirst();
            sum -= to_remove;
            map.put(to_remove, map.getOrDefault(to_remove, 0) -1);
            if (map.getOrDefault(to_remove, 0) == 0) map.remove(to_remove);
        }
    }
    public int calculateMKAverage() {
        if (dq.size() < m) return -1;
        int first_smallest_sum = 0, first_largest_sum = 0, count = 0, current_key = map.firstKey();
        while (count < k) {
            if (map.get(current_key) + count <= k) {
                count += map.get(current_key);
                first_smallest_sum += map.get(current_key) * current_key;
                current_key = map.higherKey(current_key);
            }
            else {
                first_smallest_sum += current_key * (k - count);
                break;
            }
        }
        current_key = map.lastKey();
        count = 0;
        while (count < k) {
            if (map.get(current_key) + count <= k) {
                first_largest_sum += map.get(current_key) * current_key;
                count += map.get(current_key);
                current_key = map.lowerKey(current_key);
            }
            else {
                first_largest_sum += current_key * (k - count);
                break;
            }
        }
        int res = sum - first_smallest_sum - first_largest_sum;
        return res / (m - 2 * k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */