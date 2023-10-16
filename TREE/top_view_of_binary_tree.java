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


import java.util.*;


//class Pair{
//    Node node;
//
//    int vertical;
//    public Pair(Node node , int vertical){
//        this.node = node;
//        this.vertical = vertical;
//    }
//}
public class top_view_of_binary_tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = top_view(root);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();


    }

    public static ArrayList<Integer> top_view(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair current = q.poll();
            Node node = current.node;
            int vertical = current.vertical;
            if(!map.containsKey(vertical)){
                map.put(vertical, node.data);
            }
            if(node.left != null) q.offer(new Pair(node.left,vertical - 1));
            if(node.right != null) q.offer(new Pair(node.right,vertical + 1));

        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;



    }
}
