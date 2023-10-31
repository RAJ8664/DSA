package Sliding_window;

import java.util.HashMap;
import java.util.Scanner;

public class fruit_into_baskets {
    //read the problem statement at coding ninja
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = solve(arr);
        System.out.println(ans);
    }

    public static int solve(int arr[]){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int start = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            while(start + 1 < n && map.size() < 2 || start + 1 < n && map.containsKey(arr[start + 1])){
                start++;
                map.put(arr[start] , map.getOrDefault(arr[start] , 0) + 1);
            }
            max = Math.max(max, start - i + 1);
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) - 1);
            if(map.get(arr[i]) <= 0) map.remove(arr[i]);
        }
        return max;
    }
}
