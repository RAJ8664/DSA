package TREE;

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

public class Height_of_Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(height(root));
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight=  height(root.right);
        return Math.max(lheight , rheight) + 1;
    }
}
