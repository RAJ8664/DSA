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
import java.util.LinkedList;
import java.util.Queue;

public class left_right_view_of_binary_tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = left_view(root);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> ans1 = new ArrayList<>();
        ans1 = right_view(root);
        for(int i = 0; i < ans1.size(); i++){
            System.out.print(ans1.get(i) + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> left_view(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                if(i == 0){
                    ans.add(q.poll().data);
                }
                else{
                    q.poll();
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> right_view(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                if(i == len - 1){
                    ans.add(q.poll().data);
                }
                else{
                    q.poll();
                }
            }
        }
        return ans;
    }
}
