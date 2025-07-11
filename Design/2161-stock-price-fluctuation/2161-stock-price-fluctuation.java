
import java.util.HashMap;
import java.util.TreeSet;

class StockPrice {
    private HashMap<Integer, Integer> prices;
    HashMap<Integer, Integer> map;
    private int last;
    private TreeSet<Integer> set;
    public StockPrice() {
        prices = new HashMap<>();
        last = -1;
        set = new TreeSet();
        map = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        last = Math.max(last, timestamp);
        if (prices.containsKey(timestamp) && prices.getOrDefault(timestamp, 0) > 0) {
            int lastVal = prices.get(timestamp);
            map.put(lastVal, map.getOrDefault(lastVal, 0) -1);
            if (map.getOrDefault(lastVal, 0) == 0) {
                set.remove(lastVal);
                map.remove(lastVal);
            }
            prices.put(timestamp, price);
            map.put(price, map.getOrDefault(price, 0) + 1);
            set.add(price);
        } else {
            prices.put(timestamp, price);
            map.put(price, map.getOrDefault(price, 0) + 1);
            set.add(price);
        }
    }

    public int current() {
        return prices.get(last);
    }

    public int maximum() {
        return set.last();
    }

    public int minimum() {
        return set.first();
    }
}

/**
    Your StockPrice object will be instantiated and called as such:
    StockPrice obj = new StockPrice();
    obj.update(timestamp,price);
    int param_2 = obj.current();
    int param_3 = obj.maximum();
    int param_4 = obj.minimum();
*/