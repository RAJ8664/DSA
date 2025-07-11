import java.util.HashMap;

class FindSumPairs {
    private HashMap<Integer, Integer> map;
    private int arr[];
    private int brr[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        arr = new int[nums1.length];
        brr = new int[nums2.length];
        for (int ele : nums2)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (int i = 0; i < nums1.length; i++)
            arr[i] = nums1[i];
        for (int i = 0; i < nums2.length; i++)
            brr[i] = nums2[i];
    }

    public void add(int index, int val) {
        int lastVal = brr[index];
        map.put(lastVal, map.getOrDefault(lastVal, 0) -1);
        if (map.getOrDefault(lastVal, 0) == 0)
            map.remove(lastVal);
        brr[index] += val;
        map.put(brr[index], map.getOrDefault(brr[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int req = tot - current;
            count += map.getOrDefault(req, 0);
        }
        return count;
    }
}