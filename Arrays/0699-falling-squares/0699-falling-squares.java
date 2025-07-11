class Solution {
    static class Tuple {
        int start, end, height;
        public Tuple(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
        @Override
        public String toString() {
            return "(" + start + " " + end + " " + height + ")";
        }
    }
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        ArrayList<Tuple> res = new ArrayList<>();
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int l = positions[i][0], r = l + positions[i][1] - 1, height = positions[i][1];
            maxi = Math.max(maxi, solve(res, new Tuple(l, r, height)));
            ans.add(maxi);
        }
        return ans;
    }
    private int solve(ArrayList<Tuple> res, Tuple current) {
        int curr_maxi = 0;
        for (Tuple x : res) {
            if (x.end < current.start || x.start > current.end) continue;
            curr_maxi = Math.max(curr_maxi, x.height);
        }
        current.height += curr_maxi;
        res.add(current);
        return current.height;
    }
}