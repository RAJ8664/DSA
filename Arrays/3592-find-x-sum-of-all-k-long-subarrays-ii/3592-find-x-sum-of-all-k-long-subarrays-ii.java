class Solution {
    static class Pair {
        int node, freq;
        public Pair(int node, int freq) {
            this.node = node;
            this.freq = freq;
        }
        @Override
        public String toString() {
            return "(" + node + " " + freq + ")";
        }
        @Override
        public int hashCode() {
            return Objects.hash(node, freq);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair current = (Pair)(obj);
            return current.node == node && current.freq == freq;
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(second.freq, first.freq);
            if (op1 != 0) return op1;
            return Integer.compare(second.node, first.node);
        }
    }
    public static long[] findXSum(int[] arr, int k, int x) {
        int n = arr.length, p = 0;
        long res[] = new long[n - k + 1]; 
        TreeSet<Pair> set = new TreeSet<>(new custom_sort());
        HashMap<Integer, Integer> map = new HashMap<>(); 
        TreeSet<Pair> removed = new TreeSet<>(new custom_sort());
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int current = arr[i];
            if (map.containsKey(current)) {
                if(set.contains(new Pair(current, map.getOrDefault(current, 0)))) sum -= current * 1L * map.getOrDefault(current, 0);
                if (removed.contains(new Pair(current, map.getOrDefault(current, 0)))) removed.remove(new Pair(current, map.getOrDefault(current, 0)));
                set.remove(new Pair(current, map.getOrDefault(current, 0)));
                
                map.put(current, map.getOrDefault(current, 0) + 1);
                sum += current * 1L * map.getOrDefault(current, 0);
                set.add(new Pair(current, map.getOrDefault(current, 0)));
                if (set.size() > x) {
                    Pair last = set.pollLast();
                    sum -= last.node * 1L * last.freq;
                    removed.add(new Pair(last.node, map.getOrDefault(last.node, 0)));
                }
            }
            else {
                map.put(current, 1);
                set.add(new Pair(current, 1));
                sum += current;
                if (set.size() > x) {
                    Pair last = set.pollLast();
                    sum -= last.node * 1L * last.freq;
                    removed.add(new Pair(last.node, map.getOrDefault(last.node, 0)));
                }
            }
            while (removed.size() > 0) {
                Pair second = removed.first();
                Pair first = set.last();
                if (second.freq > first.freq || (second.freq == first.freq && second.node > first.node)) {
                    sum += second.node * 1L *  second.freq;
                    set.add(removed.pollFirst());
                    if (set.size() > x) {
                        Pair r = set.last();
                        removed.add(set.pollLast());
                        sum -= r.node * 1L * r.freq;
                    }
                }
                else break;
            }
        }
        res[p++] = sum;
        int start = 0;
        for (int i = k; i < n; i++) {
            int prev = arr[start++];
            if(set.contains(new Pair(prev, map.getOrDefault(prev, 0)))) sum -= prev * 1L * map.getOrDefault(prev, 0);
            if (removed.contains(new Pair(prev, map.getOrDefault(prev, 0)))) removed.remove(new Pair(prev, map.getOrDefault(prev, 0)));
            set.remove(new Pair(prev, map.getOrDefault(prev, 0)));

            map.put(prev, map.getOrDefault(prev, 0) -1);
            sum += prev * 1L * map.getOrDefault(prev, 0);
            set.add(new Pair(prev, map.getOrDefault(prev, 0)));

            if (set.size() > x) {
                Pair last = set.pollLast();
                sum -= last.node * 1L * last.freq;
                removed.add(new Pair(last.node, map.getOrDefault(last.node, 0)));
            }
            int now = arr[i];
            if(set.contains(new Pair(now, map.getOrDefault(now, 0)))) sum -= now * 1L * map.getOrDefault(now, 0);
            if (removed.contains(new Pair(now, map.getOrDefault(now, 0)))) removed.remove(new Pair(now, map.getOrDefault(now, 0)));
            set.remove(new Pair(now, map.getOrDefault(now, 0)));
            
            map.put(now, map.getOrDefault(now, 0) + 1);
            sum += now * 1L * map.getOrDefault(now, 0);
            set.add(new Pair(now, map.getOrDefault(now, 0)));

            if (set.size() > x) {
                Pair last = set.pollLast();
                sum -= last.node * 1L * last.freq;
                removed.add(new Pair(last.node, map.getOrDefault(last.node, 0)));
            }
            while (removed.size() > 0) {
                Pair second = removed.first();
                Pair first = set.last();
                if (second.freq > first.freq || (second.freq == first.freq && second.node > first.node)) {
                    sum += second.node * 1L * map.getOrDefault(second.node, 0);
                    set.add(removed.pollFirst());
                    if (set.size() > x) {
                        Pair r = set.last();
                        removed.add(set.pollLast());
                        sum -= r.node * 1L * r.freq;
                    }
                }
                else break;
            }
            res[p++] = sum;
        }
        return res;
    }
}