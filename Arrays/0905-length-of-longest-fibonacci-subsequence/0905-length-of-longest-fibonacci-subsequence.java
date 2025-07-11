class Solution {
    private HashMap<Integer, TreeSet<Integer>> map;
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int maxi = 0;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                TreeSet<Integer> temp = new TreeSet<>();
                temp = map.get(arr[i]);
                temp.add(i);
                map.put(arr[i] , new TreeSet<>(temp));
            }
            else {
                map.put(arr[i] , new TreeSet<Integer>());
                TreeSet<Integer> temp = new TreeSet<>();
                temp.add(i);
                map.put(arr[i] , new TreeSet<>(temp)); 
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i] , b = arr[j];
                int count = 2, prev_ind = j;
                while (true) {
                    //check find the first index greater than prev_ind which is equal to a + b;
                    int res = check(a + b , prev_ind, n - 1);
                    if (res == -1) break;
                    else {
                        prev_ind = res;
                        int search = a + b;
                        a = b;
                        b = search;
                        count++;
                    }
                }
                if (count >= 3) maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
    private int check(int target, int low, int high) {
        if (map.containsKey(target)) {
            TreeSet<Integer> current = map.get(target);
            if (current.higher(low) != null) return current.higher(low);
            return -1;
        }
        return -1;
    }
}