public class FInd_first_and_last_occurences_of_element {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 5, 5, 6, 7, 8};
        System.out.println(first_occurence(arr, 5));
        System.out.println(last_occurence(arr, 5));
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
