class NumberContainers {
    private HashMap<Integer, TreeSet<Integer>> map;
    private HashMap<Integer, Integer> info;
    public NumberContainers() {
        map = new HashMap<>();
        info = new HashMap<>();
    }
    public void change(int index, int number) {
        if (info.containsKey(index)) {
            int prev_number = info.get(index);
            TreeSet<Integer> prev = map.get(prev_number);
            prev.remove(index);
            if (!map.containsKey(number)) map.put(number, new TreeSet<>());
            map.get(number).add(index);
            info.put(index, number);
        }
        else {
            if (!map.containsKey(number)) map.put(number, new TreeSet<>());
            map.get(number).add(index);
            info.put(index, number);
        }
    }
    public int find(int number) {
        if (map.containsKey(number)) {
            TreeSet<Integer> temp = new TreeSet<>();
            temp = map.get(number);
            if (temp.size() == 0) return -1;
            return temp.first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */