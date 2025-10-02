class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            map.computeIfAbsent(current, k->new ArrayList<>()).add(i);
        }
        int res = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            if (!map.containsKey(i)) continue;
            ArrayList<Integer> current = new ArrayList<>();
            current = map.get(i);
            int prev = 0;
            for (int j = 0; j < current.size(); j++) {
                int left = 0, right = 0;
                if (j == 0) left = current.get(j);
                else left = current.get(j) - current.get(j - 1) - 1;
                if (j == current.size() - 1) right = n - current.get(j) - 1;
                else right = current.get(j + 1) - current.get(j) - 1;
                res += 1 + left + (right * (left + 1));
            }
        }
        return res;
    }
}
