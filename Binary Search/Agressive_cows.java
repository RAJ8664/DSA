import java.util.Arrays;

public class Agressive_cows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        System.out.println(optimal_approach(arr, 3));
    }

    public static int optimal_approach(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];

        }
        int low = 1;
        int high = max;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (!is_possible(arr, mid, k))
                high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int bruteforce(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];

        }
        for (int i = max; i >= 1; i--) {
            if (is_possible(arr, i, k))
                return i;
        }
        return -1;
    }

    public static boolean is_possible(int[] arr, int x, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int current = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - current >= x) {
                count++;
                current = arr[i];
            }
            if (count == k)
                return true;
        }
        return false;
    }
}
