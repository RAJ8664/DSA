class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        long count1 = 0, count2 = 0;
        long sum1 = 0, sum2 = 0;
        for (int ele : nums1) {
            sum1 += ele;
            if (ele == 0) count1++;
        } 
        for (int ele : nums2) {
            sum2 += ele;
            if (ele == 0) count2++;
        }
        if (sum1 > sum2) {
            long diff = sum1 - sum2;
            if (count2 == 0) return -1;
            if (count1 == 0 && sum2 + count2 > sum1) return -1;
            else {
                return (Math.max(sum1 + count1, sum2 + count2));
            }
        }
        else if (sum2 > sum1) {
            long diff = sum2 - sum2;
            if (count1 == 0) return -1;
            if (count2 == 0 && sum1 + count1 > sum2) return -1;
            else {
                return (Math.max(sum2 + count2, sum1 + count1));
            }
        }
        else if (sum1 == sum2) {
            if (count1 == 0 && count2 == 0) return sum1;
            else if (count1 > 0 && count2 == 0) return -1;
            else if (count2 > 0 && count1 == 0) return -1;
            return (Math.max(sum1 + count1, sum2 + count2));
        }
        return -1;
    }
}