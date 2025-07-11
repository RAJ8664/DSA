class Skiplist {
    private TreeSet<Integer> set;
    private HashMap<Integer, Integer> map; 
    public Skiplist() {
        set = new TreeSet<>();
        map = new HashMap<>();
    }
    
    public boolean search(int target) {
        if (set.contains(target)) return true;
        return false;
    }
    
    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        set.add(num);
    }
    
    public boolean erase(int num) {
        if (!set.contains(num)) return false;
        map.put(num, map.getOrDefault(num, 0) -1);
        if (map.getOrDefault(num ,0) == 0) {
            map.remove(num);
            set.remove(num);
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */