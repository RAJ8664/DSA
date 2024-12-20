import java.util.ArrayList;
import java.util.Scanner;

public class First_negative_number_in_every_window_of_size_k {
    /*Given an array A[] of size N and a positive integer K,
    find the first negative integer for each and every window(contiguous subarray) of size K.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        ans = optimal_approach(arr,k);
        for(int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
    }

    //bruteforce
    public static ArrayList<Integer> bruteforce(int arr[], int k){
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n - k + 1; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = i; j < n; j++){
                if(j - i + 1 <= k) temp. add(arr[j]);
            }
            ans.add(temp);
        }
        ArrayList<Integer> fans = new ArrayList<>();
        for(ArrayList<Integer> current : ans) {
            int len = current.size();
            boolean found = false;
            for (int i = 0; i < len; i++) {
                if (current.get(i) < 0) {
                    fans.add(current.get(i));
                    found = true;
                    break;
                }
            }
            if (!found)  fans.add(0);
        }
        return fans;
    }

    public static ArrayList<Integer> optimal_approach(int arr[],int k){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n - k + 1; i++){
            boolean found = false;
            int temp = 0;
            for(int j = i; j < i + k; j++){
                if(arr[j] <0){
                    temp = arr[j];
                    found = true;
                    break;
                }
            }
            if(found) ans.add(temp);
            else ans.add(0);
        }
        return ans;
    }

     //optimal solution;
    public static ArrayList<Integer> first_negative_number(int arr[], int k){
        // k here is the size of window;
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] < 0) q.offer(i);
        }
        int i = 0, j = k - 1;
        while(j < n){
            if(!q.isEmpty() && q.peek() >= i && q.peek() <= j) ans.add(arr[q.peek()]);
            else {
                while(!q.isEmpty() && q.peek() < i) q.poll();
                if(!q.isEmpty() && q.peek() >= i && q.peek() <= j) ans.add(arr[q.peek()]);
                else ans.add(0);
            }
            i++; j++;
        }
        return ans;
    }    
}
