package Sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class smallest_distinct_window {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }

    public static int solve(String s){
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(s.charAt(i));
        }
        HashMap<Character,Integer> map  = new HashMap<>();
        int len = set.size();
        int start = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            while(start + 1 < n && map.size() != len){
                start++;
                map.put(s.charAt(start),map.getOrDefault(s.charAt(start), 0) + 1);
            }
            if(map.size() == len){
                min = Math.min(min,start - i + 1);
            }

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            if(map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
        }
        return min;
    }
}
