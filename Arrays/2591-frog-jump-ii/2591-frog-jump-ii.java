class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int low = 0, high = (int)(1e9 + 10), ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, stones)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private boolean ok(int target, int arr[]) {
        int n = arr.length;
        int currIdx = 0;
        int vis[] = new int[n + 1];
        while (currIdx < n) {
            if (currIdx == n - 1)
                break;
            int low = currIdx + 1, high = n - 1, ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Math.abs(arr[mid] - arr[currIdx]) <= target) {
                    ans = mid;
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
            if (ans == -1)
                return false;
            currIdx = ans;
            vis[ans] = 1;
        }

        currIdx = n - 1;
        while (currIdx >= 0) {
            if (currIdx == 0)
                return true;
            int low = 0, high = currIdx - 1, ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Math.abs(arr[mid] - arr[currIdx]) > target)
                    low = mid + 1;
                else if (Math.abs(arr[mid] - arr[currIdx]) <= target && vis[mid] == 0) {
                    ans = mid;
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
            if (ans == -1)
                return false;
            currIdx = ans;
            vis[ans] = 1;
        }
        return true;
    }
}