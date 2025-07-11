class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        int n = arr.length;
        int maxi_sum = 0, current_sum = 0, left = 0, right = 0;
        HashSet<Integer> set = new HashSet<>();
        while (left < n) {
            while (right < n && !set.contains(arr[right])) {
                set.add(arr[right]);
                current_sum += arr[right];
                right++;
            }
            maxi_sum = Math.max(maxi_sum, current_sum);
            current_sum -= arr[left];
            set.remove(arr[left]);
            left++;
        }
        return maxi_sum;
    }
}