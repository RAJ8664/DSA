class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int low = 0, high = Math.min(n, workers.length), ans = 0;
        Arrays.sort(tasks);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, tasks, workers, strength, pills)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    private boolean ok(int mid, int tasks[], int workers[], int strength, int pills) {
        int n = tasks.length;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int ele : workers) {
            set.add(ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int i = mid - 1; i >= 0; i--) {
            int current_task = tasks[i];
            if (set.ceiling(current_task) != null) {
                int current_worker = set.ceiling(current_task);
                map.put(current_worker, map.getOrDefault(current_worker, 0) -1);
                if (map.getOrDefault(current_worker, 0) == 0) {
                    map.remove(current_worker);
                    set.remove(current_worker);
                }
            }
            else {
                if (pills == 0) return false;
                if (set.ceiling(current_task - strength) == null) return false;
                pills--;
                int current_worker = set.ceiling(current_task - strength);
                map.put(current_worker, map.getOrDefault(current_worker, 0) -1);
                if (map.getOrDefault(current_worker, 0) == 0) {
                    map.remove(current_worker);
                    set.remove(current_worker);
                }
            }
        }
        return true;
    }
}