package TREE;


//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        left = right =null;
//    }
//}


public class children_sum_property {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    }

    public static void change(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;

        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        change(root.left);
        change(root.right);

        int total = 0;
        if(root.left != null) total  += root.left.data;
        if(root.right != null) total += root.right.data;
        //change the root value if it is not leaf node;
        if(root.left != null || root.right != null) root.data = total;
    }


    public static boolean check_for_children_sum_property(Node root){
        if(root.left == null && root.right == null) return true;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;
        if(child != root.data) return false;

        boolean lh = true;
        boolean rh = true;
        if(root.left != null) {
            lh = check_for_children_sum_property(root.left);

        }
        if(root.right != null) {
            rh = check_for_children_sum_property(root.right);
        }
        return lh & rh;

    }
}
