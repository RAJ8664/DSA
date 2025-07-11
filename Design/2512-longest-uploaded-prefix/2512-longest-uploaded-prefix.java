class LUPrefix {
    private static long seg[];
    private HashSet<Integer> set;
    public LUPrefix(int n) {
        seg = new long[4 * ((int)(1e5 + 1)) + 1];
        set = new HashSet<>();
    }
    
    public void upload(int video) {
        if (set.contains(video)) return;
        set.add(video);
        update(0, 0, (int)(1e5), video, video);
    }
    
    public int longest() {
        int low = 0;
        int high = (int)(1e5);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    private boolean ok(int mid) {
        long current_sum = query(0 , 0 , (int)(1e5) , 0 , mid);
        long req_sum = mid * 1L * (mid + 1) / 2;
        if (req_sum == current_sum) return true;
        return false;
    }

    //Segment Tree Implementation;
    private static void update(int ind, int low, int high, int index, int val){
        if(low == high){
            seg[ind] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if(index <= mid) update(2 * ind + 1, low, mid, index, val);
        else update(2 * ind + 2, mid + 1, high ,index, val);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];

    }
    private static long query(int ind, int low, int high , int l, int r){
        if(low >= l && high <= r) return seg[ind];
        if(low > r || high < l) return 0;
        int mid = low + (high - low) / 2;
        long left = query(2 * ind + 1, low , mid, l, r);
        long right = query(2 * ind + 2, mid + 1, high , l, r);
        return left + right;
    }
    
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */