package GRAPH;
import java.util.*;
public class Number_of_provinces {
    public static void main(String[] args) {
        //Take input in the adjacency matrix;
        //return findCircleNum method to get the answer;
    }
    public int findCircleNum(int[][] isConnected) {

        //Adjacency List;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < isConnected.length; i++){
            adj.add(new ArrayList<>());
        }

        //Method to convert the adjacency matrix to adjacency List;
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int vis[] = new int[isConnected.length + 1];
        Arrays.fill(vis,0);
        int count = 0;
        for(int i = 0;i  < isConnected.length; i++){
            if(vis[i] == 0){
                count++;
                dfs(i,adj,vis);

            }
        }
        return count;
    }

    //dsf function;
    public static void dfs(int current, ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[current] = 1;
        for(int ele : adj.get(current)){
            if(vis[ele] == 0 ){
                dfs(ele,adj,vis);
            }
        }
    }
}
