package GRAPH.Topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class alien_dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String arr[] = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= k + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            String first = arr[i];
            String second = arr[i + 1];
            int a = 0;
            int b = 0;
            while(a < first.length() && b < second.length()) {
                if(first.charAt(b) != second.charAt(b)) {
                    adj.get(first.charAt(a) - 'a').add(second.charAt(b) - 'a');
                    break;
                }
                else {
                    a++;
                    b++;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans = topo(adj,k);
        String res = "";
        for(int i = 0; i < ans.size(); i++) {
            char temp = (char)(ans.get(i) + (int)('a'));
            res = res + temp;
        }
        System.out.println(res);
    }

    public static ArrayList<Integer> topo(ArrayList<ArrayList<Integer>> adj, int k) {
        int indegree[] = new int[k + 1];
        for(ArrayList<Integer> current : adj) {
            for(int ele : current) indegree[ele]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int current = q.peek();
            q.poll();
            ans.add(current);
            for(int child : adj.get(current)) {
                indegree[child]--;
                if(indegree[child] == 0) q.offer(child);
            }
        }
        return ans;
    }
}
