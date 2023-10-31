package Sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class count_distinct_element_in_evey_window_of_size_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solve(arr,k);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }


    public static ArrayList<Integer> solve(int arr[],int k ){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            int cur = arr[i];
            map.put(cur,map.getOrDefault(cur, 0) + 1);
        }
        ans.add(map.size());
        int start = 0;
        for(int i = k; i < n; i++){
            int current = arr[i];
            map.put(current,map.getOrDefault(current , 0) + 1);
            int re = arr[start++];
            map.put(re,map.getOrDefault(re, 0 ) - 1);
            if(map.get(re) <= 0) map.remove(re);
            ans.add(map.size());

        }
        return ans;
    }
}
