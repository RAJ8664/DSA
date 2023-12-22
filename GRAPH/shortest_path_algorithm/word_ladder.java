package GRAPH.shortest_path_algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class word_ladder {
    static class pair {
        String current;
        int steps;
        public pair(String current, int  steps) {
            this.current = current;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String start = sc.next();
        String target = sc.next();
        String arr[] = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int ans = solve(start, target, arr);
        System.out.println(ans);
    }

    public static int solve(String start, String target, String arr[]) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(start, 1));
        set.remove(start);
        while(!q.isEmpty()) {
            String current = q.peek().current;
            int step = q.peek().steps;
            q.poll();
            if(current.equals(target)) return step;
            for(int i = 0; i < current.length(); i++) {
                for(char c = 'a' ; c <= 'z'; c++) {
                    char temp[] = current.toCharArray();
                    temp[i] = c;
                    String check = new String(temp);
                    if(set.contains(check)) {
                        q.offer(new pair(check , step + 1));
                        set.remove(check);
                    }
                }
            }
        }
        return 0;
    }
}
