package TREE;

import java.util.ArrayList;

//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        this.left = left;
//        this.right = right;
//    }
//}
public class boundary_traversal_of_tree {
    //read the problem statement;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = boundary_traversal(root);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }


    public static ArrayList<Integer> boundary_traversal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(isleaf(root) == false) {
            ans.add(root.data);
        }
        addleftboundary(root,ans);
        addleaf(root,ans);
        addrightboundary(root,ans);
        return ans;
    }
    public static boolean isleaf(Node root){
        if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }
    public static void addleftboundary(Node root,ArrayList<Integer> ans){
        Node current = root.left;
        while(current != null){
            if(isleaf(current) == false){
                ans.add(current.data);
            }
            if(current.left != null){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
    }
    public static void addrightboundary(Node root,ArrayList<Integer> ans){
        Node current = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(current != null){
            if(isleaf(current) == false){
                temp.add(current.data);
            }
            if(current.right != null){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        for(int i = temp.size() - 1; i >= 0; i--){
            ans.add(temp.get(i));
        }
    }
    public static void addleaf(Node root,ArrayList<Integer> ans){
        if(isleaf(root) == true){
            ans.add(root.data);
            return;
        }
        if(root.left != null) addleaf(root.left,ans);
        if(root.right != null) addleaf(root.right,ans);
    }
}
