import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        int flag[] = new int[dictionary.size()];
        for (int i = 0; i < dictionary.size(); i++) {
            if (canForm(s, dictionary.get(i)))
                flag[i] = 1;
        }
        int maxi = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            if (flag[i] == 1)
                maxi = Math.max(maxi, dictionary.get(i).length());
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < dictionary.size(); i++) {
            if (flag[i] == 1 && dictionary.get(i).length() == maxi)
                res.add(dictionary.get(i));
        }
        Collections.sort(res);
        if (res.size() == 0)
            return "";
        return res.get(0);
    }

    private boolean canForm(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else
                i++;
        }
        return j == m;
    }
}