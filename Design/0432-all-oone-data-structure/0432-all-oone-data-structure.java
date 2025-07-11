import java.util.*;
class AllOne {
    private HashMap<String, Integer> map;
    private TreeMap<Integer, HashSet<String>> freqMap;
    public AllOne() {
        map = new HashMap<>();
        freqMap = new TreeMap<>();
    }
    public void inc(String key) {
        if (map.containsKey(key)) {
            int freq = map.get(key);
            map.put(key, freq + 1);
            freqMap.get(freq).remove(key);
            if (freqMap.get(freq).isEmpty()) freqMap.remove(freq);
            freqMap.computeIfAbsent(freq + 1, k -> new HashSet<>()).add(key);
        } 
        else {
            map.put(key, 1);
            freqMap.computeIfAbsent(1, k -> new HashSet<>()).add(key);
        }
    }
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        int freq = map.get(key);
        if (freq == 1) {
            map.remove(key);
            freqMap.get(1).remove(key);
            if (freqMap.get(1).isEmpty()) freqMap.remove(1);
        } 
        else {
            map.put(key, freq - 1);
            freqMap.get(freq).remove(key);
            if (freqMap.get(freq).isEmpty()) {
                freqMap.remove(freq);
            }
            freqMap.computeIfAbsent(freq - 1, k -> new HashSet<>()).add(key);
        }
    }
    public String getMaxKey() {
        if (freqMap.isEmpty()) return "";
        return freqMap.lastEntry().getValue().iterator().next();
    }
    public String getMinKey() {
        if (freqMap.isEmpty()) return "";
        return freqMap.firstEntry().getValue().iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
