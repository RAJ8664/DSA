class MapSum {
    private HashMap<String , Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        map.put(key , val);
    }
    public int sum(String prefix) {
        int Total_Sum = 0;
        for (Map.Entry<String, Integer> curr : map.entrySet()) {
            String key = curr.getKey();
            if (key.startsWith(prefix)) Total_Sum += curr.getValue();
        }
        return Total_Sum;
    }
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
