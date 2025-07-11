import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> peopleIndexes(List<List<String >> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<String >> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (String s : favoriteCompanies.get(i)) {
                if (!map.containsKey(i))
                    map.put(i, new ArrayList<>());
                map.get(i).add(s);
            }
        }
        for (Map.Entry<Integer, ArrayList<String >> entry : map.entrySet()) {
            int key = entry.getKey();
            ArrayList<String> currentCmp = entry.getValue();
            boolean flag = true;
            for (Map.Entry<Integer, ArrayList<String >> otherEntry : map.entrySet()) {
                if (key == otherEntry.getKey())
                    continue;
                ArrayList<String> otherCmp = otherEntry.getValue();
                HashSet<String> set = new HashSet<>(otherCmp);
                boolean containsAll = true;
                for (String x : currentCmp) {
                    if (!set.contains(x)) {
                        containsAll = false;
                        break;
                    }
                }
                if (containsAll) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}