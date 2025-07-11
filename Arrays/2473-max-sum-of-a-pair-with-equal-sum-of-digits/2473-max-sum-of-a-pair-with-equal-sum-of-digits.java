class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, MultiSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = nums[i], sum = 0;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }
            if (!map.containsKey(sum)) map.put(sum, new MultiSet<>());
            map.get(sum).add(nums[i]);
        }
        int maxi = 0;
        for (Map.Entry<Integer, MultiSet<Integer>> x : map.entrySet()) {
            MultiSet<Integer> temp = x.getValue();
            if (temp.size <= 1) continue;
            int current_sum = temp.last();
            temp.remove(temp.last());
            current_sum += temp.last();
            maxi = Math.max(maxi, current_sum);
        } 
        if (maxi == 0) return -1;
        return maxi;
    }
    static class MultiSet<T> {
        TreeMap<T, Integer> frequency;
        TreeSet<T> set;
        int size;
        public MultiSet() {
            set = new TreeSet<>();
            frequency = new TreeMap<>();
            size = 0;
        }
        public void add(T elem) {
            if (frequency.get(elem) == null || frequency.get(elem) == 0) {
                frequency.put(elem, 0);
                set.add(elem);
            }
            frequency.put(elem, frequency.get(elem) + 1);
            size++;
        }
        public void remove(T elem) {
            if (!set.contains(elem)) return;
            frequency.put(elem, frequency.get(elem) - 1);
            if (frequency.get(elem) == 0) {
                set.remove(elem);
                frequency.remove(elem);
            }
            size--;
        }
        public T last() { return set.last(); }
    }
}