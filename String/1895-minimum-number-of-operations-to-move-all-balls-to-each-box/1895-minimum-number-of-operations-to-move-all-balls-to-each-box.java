class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int res[] = new int[n];
        ArrayList<Integer> ind = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') ind.add(i);
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < ind.size(); j++) {
                cnt += Math.abs(i - ind.get(j));
            }
            res[i] = cnt;
        }
        return res;
    }
}