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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class minimum_time_to_burn_binary_tree {
    //Read the problem statement;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);
        int ans = minimum_time(root,8);
        System.out.println(ans);
    }




    //here target given is integer so we need to find the target node by ourself;
    public static int minimum_time(Node root, int target){
        HashMap<Node,Node> parent = new HashMap<>();
        build_parent(parent,root);
        HashMap<Node,Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node found = get(root,target);
        q.offer(found);
        visited.put(found,true);
        int count = 0;
        while(!q.isEmpty()){
            int len = q.size();
            count++;
            for(int i = 0; i < len; i++){
                Node current = q.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent.get(current) != null && visited.get(parent.get(current)) == null){
                    q.offer(parent.get(current));
                    visited.get(parent.get(current));
                }
            }
        }
        return count - 1;
    }

    public static void build_parent(HashMap<Node,Node> map , Node root){
       Queue<Node> q = new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()) {
           int len = q.size();
           for (int i = 0; i < len; i++) {
               Node current = q.poll();
               if (current.left != null) {
                   q.offer(current.left);
                   map.put(current.left, current);
               }
               if (current.right != null) {
                   q.offer(current.right);
                   map.put(current.right, current);
               }
           }
       }
    }

    public static Node get(Node root, int target){
        if(root == null) return null;
        if(root.data == target) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node current = q.poll();
                if(current.data == target) return current;
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
        }
        return null;
    }
}
