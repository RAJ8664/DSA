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

//uncomment the Node class;
public class Post_Order_Traversal {
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = get_Post_order(root);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> get_Post_order(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Post_Order(root,ans);
        return ans;
    }

    public static void Post_Order(Node root,ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        Post_Order(root.left,ans);
        Post_Order(root.right,ans);
        ans.add(root.data);
    }
}
