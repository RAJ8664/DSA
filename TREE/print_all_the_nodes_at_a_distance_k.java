package TREE;


//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        left = right = null;
//    }
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class print_all_the_nodes_at_a_distance_k {
    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       ArrayList<Integer> ans = new ArrayList<>();
       ans = print_all_nodes(root,2,root.left.left);
        System.out.println(ans);

    }

    public static void build_parent(HashMap<Node, Node> map, Node root, int k){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node current = q.poll();
                if(current.left != null) {
                    map.put(current.left , current);
                    q.offer(current.left);
                }
                if(current.right != null){
                    map.put(current.right , current);
                    q.offer(current.right);
                }
            }
        }
    }

    public static ArrayList<Integer> print_all_nodes(Node root,int k,Node target){
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Node,Node> parent = new HashMap<>();
        build_parent(parent,root,k);
        Queue<Node> q = new LinkedList<>();
        HashMap<Node ,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int count = 0;
        while(!q.isEmpty()){
           if(count == k) break;
           int len = q.size();
           count++;
           for(int i = 0; i < len; i++){
               Node current = q.poll();
               if(current.left != null && visited.get(current.left) == null){
                   visited.put(current.left , true);
                   q.offer(current.left);
               }
               if(current.right != null && visited.get(current.right) == null){
                   visited.put(current.right,true);
                   q.offer(current.right);
               }
               if(parent.get(current) != null && visited.get(parent.get(current)) == null){
                   visited.put(parent.get(current) , true);
                   q.offer(parent.get(current));
               }
           }
        }

        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        return ans;
    }
}
