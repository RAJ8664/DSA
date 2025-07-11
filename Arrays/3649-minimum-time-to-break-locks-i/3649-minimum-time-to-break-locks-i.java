import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size(), mini = Integer.MAX_VALUE;

        int total = 1;
        for (int i = 1; i <= n; i++)
            total *= i;

        while (total >= 0) {
            mini = Math.min(mini, solve(strength, k));
            nextPermutation(strength);
            total--;
        }
        return mini;
    }

    private int solve(List<Integer> arr, int k) {
        int ans = 0, currentEnergy = 0, currentFactor = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % currentFactor == 0)
                ans += arr.get(i) / currentFactor;
            else
                ans += 1 + (arr.get(i) / currentFactor);
            currentFactor += k;
            currentEnergy = 0;
        }
        return ans;
    }

    private void nextPermutation(List<Integer> nums) {
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums.get(i) >= nums.get(i + 1))
            i--;
        if (i >= 0) {
            int j = n - 1;
            while (nums.get(j) <= nums.get(i))
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(List<Integer> nums, int i, int j) {
        Collections.swap(nums, i, j);
    }

    private void reverse(List<Integer> nums, int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }
}