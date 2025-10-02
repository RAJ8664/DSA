
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    static class Tuple {
        String s;
        int len, idx;
        public Tuple(String s, int len, int idx) {
            this.s = s;
            this.len = len;
            this.idx = idx;
        }
        @Override
        public String toString() {
            return "Pair{" +
                   "s='" + s + '\'' +
                   ", len=" + len +
                   ", idx=" + idx +
                   '}';
        }
    }

    static class customSort implements Comparator<Tuple> {
        @Override
        public int compare(Tuple first, Tuple second) {
            int op1 = Integer.compare(first.len, second.len);
            if (op1 != 0)
                return op1;
            return Integer.compare(first.idx, second.idx);
        }
    }

    public String arrangeWords(String text) {
        int n = text.length();
        ArrayList<Tuple> res = new ArrayList<>();
        String t = text + " ";
        StringBuilder sb = new StringBuilder();
        int currentIdx = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == ' ') {
                res.add(new Tuple(sb.toString(), sb.toString().length(), currentIdx++));
                sb = new StringBuilder();
            } else
                sb.append(t.charAt(i));
        }

        Collections.sort(res, new customSort());
        StringBuilder ans = new StringBuilder();
        int stringIdx = 0;
        for (Tuple curr : res) {
            String current = curr.s;
            for (int i = 0; i < current.length(); i++) {
                if (i == 0 && stringIdx == 0)
                    ans.append(Character.toUpperCase(current.charAt(i)));
                else
                    ans.append(Character.toLowerCase(current.charAt(i)));
            }
            stringIdx++;
            if (stringIdx != res.size())
                ans.append(" ");
        }
        return ans.toString();
    }
}