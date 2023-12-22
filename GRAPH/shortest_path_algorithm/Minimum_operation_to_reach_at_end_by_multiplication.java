package GRAPH.shortest_path_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Minimum_operation_to_reach_at_end_by_multiplication {
    //Read the problem statement on geeksforgeeks;

    static class Pair {
        int step, node;
        public Pair (int step,int node) {
            this.step = step;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int res = minimumOperations(n , start, end, arr);
        System.out.println(res);

    }

    public static int minimumOperations(int n, int start, int end, int []a) {
        //mod was give as 10 ^ 3;
        Queue<Pair> q = new LinkedList<>();
        int dist[] = new int[10000];
        Arrays.fill(dist,(int)(1e9));
        dist[start] = 0;
        if(start == end) return 0;
        q.offer(new Pair(0 , start));
        while(!q.isEmpty()) {
            int curr_node = q.peek().node;
            int curr_step = q.peek().step;
            q.poll();
            for(int i = 0; i < n; i++) {
                int res = (a[i] * curr_node) % 1000;
                if(res == end) return curr_step + 1;
                if(dist[res] > curr_step + 1) {
                    dist[res] = curr_step + 1;
                    q.offer(new Pair(dist[res] , res));
                }
            }
        }
        return -1;
    }
}
