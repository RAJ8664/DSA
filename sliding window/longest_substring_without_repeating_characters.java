package Sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = solve(s);
        System.out.println(ans);


    }

    public static int solve(String s){
        int n = s.length();
        int start = -1;
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            while(start + 1 < n  && !set.contains(s.charAt(start + 1))){
                start++;
                set.add(s.charAt(start));
                map.put(s.charAt(start),map.getOrDefault(s.charAt(start) , 0) + 1);
            }
            max = Math.max(max, start - i + 1);
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0 ) - 1);
            if(map.get(s.charAt(i)) <= 0) {
                map.remove(s.charAt(i));
                set.remove(s.charAt(i));
            }
        }
        if(max == Integer.MIN_VALUE) return 0;
        return max;
    }
}
