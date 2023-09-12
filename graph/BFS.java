package GRAPH;
import java.util.*;
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n + 1];
        Arrays.fill(vis,0);
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(1,vis,ans,adj,q);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();


    }
    public static void bfs(int current , int vis[],ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj,Queue<Integer> q){
        vis[current] = 1;
        q.add(current);
        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            ans.add(x);
            for(int ele : adj.get(x)){
                if(vis[ele] == 0){
                    q.add(ele);
                    vis[ele] = 1;
                }
            }

        }
    }
}
