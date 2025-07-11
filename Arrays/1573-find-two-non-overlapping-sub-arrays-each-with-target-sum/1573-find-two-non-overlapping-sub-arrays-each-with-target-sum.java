class Solution {
    static class Pair {
        int idx1, idx2, len;
        public Pair(int idx1, int idx2, int len) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.len = len;
        }
        @Override
        public String toString() {
            return "(" + idx1 + " " + idx2 + " "+ len + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(first.idx1, second.idx1);
            if (op1 != 0) return op1;
            return Integer.compare(first.idx2, second.idx2);
        }
    }
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Pair> res = new ArrayList<>();
        long sum = 0;
        int left = 0, right = 0;
        while (left < n) {
            while (right < n && sum + arr[right] <= target) {
                sum += arr[right++];
            }
            if (sum == target) res.add(new Pair(left, right - 1, (right - 1) - left + 1));
            sum -= arr[left++];
        }
        if (res.size() < 2) return -1;
        int mini = (int)(1e9);
        Collections.sort(res, new custom_sort());
        int cost[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) cost[i] = res.get(i).len;
        SegMent_Tree seg = new SegMent_Tree(cost.length, cost);        

        /*
                ........
                      ..........
                                ........
                                         .......    .........
        
        */

        for (int i = 0; i < res.size(); i++) {
            //binary search for closest j such that !(i , j) intersect --> then we can find the min val from j to res.size() - 1;
            int bs = binary_search(i, i + 1 , res.size() - 1, res);
            if (bs == -1) continue;
            long current = (int)(seg.query(1, 0, cost.length - 1, bs, cost.length - 1).mini);
            current += res.get(i).len;
            mini = (int)(Math.min(mini, current));
        }
        if (mini == (int)(1e9)) return -1;
        return mini;
    }
    private int binary_search(int ind, int low, int high, ArrayList<Pair> res) {
        int n = res.size();
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (!Intersect(res.get(ind), res.get(mid))) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    private boolean Intersect(Pair first, Pair second) {
        int l1 = first.idx1, r1 = first.idx2;
        int l2 = second.idx1, r2 = second.idx2;
        if (l2 >= l1 && l2 <= r1) return true;
        if (r2 >= l1 && r2 <= r1) return true;
        return false;
    }
    static class SegMent_Tree {
        static Node seg[];
        static int arr[];
        public SegMent_Tree(int n, int nums[]) {
            arr = new int[n];
            seg = new Node[4 * n + 1];
            for (int i = 0; i < 4 * n + 1; i++) {
                seg[i] = new Node();
            }
            for (int i = 0; i < n; i++) arr[i] = nums[i];
            build(1, 0, n - 1);
        }
        static class Node {
            long sum, gcd, mini, maxi;
            public Node() {
                this.sum = 0;
                this.gcd = 0;
                this.mini = Integer.MAX_VALUE;
                this.maxi = Integer.MIN_VALUE;
            }
        }
        static Node Merge(Node a, Node b) {
            Node res = new Node();
            res.sum = a.sum + b.sum;
            res.mini = Math.min(a.mini, b.mini);
            res.maxi = Math.max(a.maxi, b.maxi);
            res.gcd = GCD(a.gcd, b.gcd);
            return res;
        }
        static void build(int ind, int l, int r) {
            if (l == r) {
                seg[ind].sum = arr[l];
                seg[ind].mini = arr[l];
                seg[ind].maxi = arr[l];
                seg[ind].gcd = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(2 * ind, l, mid);
            build(2 * ind + 1, mid + 1, r);
            seg[ind] = Merge(seg[2 * ind], seg[2 * ind + 1]);
        }
        //point update -- > increase the value at index pos by value = val;        
        static void update(int ind, int l, int r, int pos, int val) {
            if (pos < l || pos > r) return;
            if (l == r) {
                seg[ind].sum = val;
                seg[ind].mini = val;
                seg[ind].maxi = val;
                seg[ind].gcd = val;
                return;
            }
            int mid = (l + r) / 2;
            update(2 * ind, l, mid, pos, val);
            update(2 * ind + 1, mid + 1, r, pos, val);
            seg[ind] = Merge(seg[2 * ind], seg[2 * ind + 1]);
        }
        static Node query(int ind, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return new Node();
            if (l >= ql && r <= qr) return seg[ind];
            int mid = (l + r) / 2;
            Node left = query(2 * ind, l, mid, ql, qr);
            Node right = query(2 * ind + 1, mid + 1, r, ql, qr);
            return Merge(left, right);
        }
    }
    static long GCD(long x, long y) {if(y == 0) return x;return GCD(y, x % y);}
}