package TREE;

public class is_symmetric {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(is_symmetric(root,root));
    }

    public static boolean is_symmetric(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null){
            boolean first = root1.data == root2.data;
            boolean second = is_symmetric(root1.left , root2.right);
            boolean third  = is_symmetric(root1.right, root2.left);
            return (first && second && third);
        }
        return false;
    }
}
