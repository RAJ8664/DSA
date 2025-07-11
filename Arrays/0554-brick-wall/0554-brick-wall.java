
import java.util.HashMap;
import java.util.List;

class Solution {
    public int leastBricks(List<List<Integer >> wall) {
        int res = 0;
        HashMap<Long, Integer> freq = new HashMap<>();
        for (List<Integer> row : wall) {
            long sum = 0;
            for (int i = 0; i < row.size(); i++) {
                sum += row.get(i);
                if (i != row.size() - 1) {
                    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                    res = Math.max(res, freq.get(sum));
                }
            }
        }
        return wall.size() - res;
    }
}