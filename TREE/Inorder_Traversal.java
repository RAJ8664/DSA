package TREE;
import java.util.ArrayList;
//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        this.left = null;
//        this.right = null;
//    }
//}
public class Inorder_Traversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans =get_Inorder(root);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> get_Inorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Inorder_Traversal(root,ans);
        return ans;
    }

    //recursive approach;
    public static void Inorder_Traversal(Node root,ArrayList<Integer> ans) {
        if(root == null){
            return;
        }
        Inorder_Traversal(root.left,ans);
        ans.add(root.data);
        Inorder_Traversal(root.right,ans);
    }
}
