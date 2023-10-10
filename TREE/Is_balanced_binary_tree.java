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
public class Is_balanced_binary_tree {

    //the absolute difference between the left height and the right height
    //of each node should be less than or equal to one;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(check(root));
        if(height_optimal(root) == -1){
            System.out.println(false);
        }
        else{
            System.out.println(true);
        }
    }

    //brute force approach;
    public static boolean check(Node root){
        if(root == null){
            return true;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        boolean left = check(root.left);
        boolean right = check(root.right);

        boolean temp = Math.abs(lh - rh) <= 1;

        if(temp && left && right) {
            return true;
        }
        return false;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }


    //optimal way change the function height of tree;
    public static int height_optimal(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = height(root.right);
        if(rh == -1){
            return -1;
        }
        if(Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh , rh) + 1;
    }
}
