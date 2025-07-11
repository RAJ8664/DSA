class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int current = 1;
        for (int i = 0; i < n; i++) {
            res.add(current);
            if (current * 10 <= n) current *= 10;
            else {
                while (current % 10 == 9 || current + 1 > n)  current /= 10;
                current++;
            }
        }
        return res;
    }
}