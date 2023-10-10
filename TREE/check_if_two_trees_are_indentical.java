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

public class check_if_two_trees_are_indentical {
    //read the problem statement;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(solve(root,root));
    }

    public static boolean solve(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 != null && root2 != null){
            boolean first = (root1.data == root2.data);
            boolean second = solve(root1.left, root2.left);
            boolean third = solve(root1.right,root2.right);
            return (first && second && third);
        }
        return false;
    }
}
