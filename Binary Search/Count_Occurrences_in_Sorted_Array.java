public class Count_Occurrences_in_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 5, 6, 7, 8, 8, 9};
        System.out.println(count(arr, 5));
    }
    public static int count(int[] arr, int x) {
        int a = first_occurence(arr, x);
        int b = last_occurence(arr, x);
        if (a == -1 || b == -1)
            return 0;
        return b - a + 1;
        //TC=O(logn);
        //SC=O(1);
    }

    public static int first_occurence(int[] arr, int x) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }

    public static int last_occurence(int[] arr, int x) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ans;
        //TC=O(logn);
        //SC=O(1);
    }
}
