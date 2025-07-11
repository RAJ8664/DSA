import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : tasks)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == 1)
                return -1;
            if (val % 3 == 0)
                total += val / 3;
            else if (val % 3 == 1)
                total += (val - 4) / 3 + 2;
            else
                total += (val - 2) / 3 + 1;
        }
        return total;
    }
}