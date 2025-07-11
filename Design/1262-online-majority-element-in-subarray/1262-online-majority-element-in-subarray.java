import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

class MajorityChecker {
    private HashMap<Integer, ArrayList<Integer >> map;
    private int nums[];
    public MajorityChecker(int[] arr) {
        int n = arr.length;
        map = new HashMap<>();
        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = arr[i];
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int threshold) {
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int index = rand.nextInt(right - left + 1) + left;
            int val = nums[index];
            ArrayList<Integer> idx = new ArrayList<>();
            idx = map.get(val);
            if (bsRight(idx, right) - bsLeft(idx, left) + 1 >= threshold)
                return val;
        }
        return -1;
    }

    private int bsLeft(ArrayList<Integer> arr, int left) {
        int n = arr.size();
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= left) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private int bsRight(ArrayList<Integer> arr, int right) {
        int n = arr.size();
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= right) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}

/**
    Your MajorityChecker object will be instantiated and called as such:
    MajorityChecker obj = new MajorityChecker(arr);
    int param_1 = obj.query(left,right,threshold);
*/