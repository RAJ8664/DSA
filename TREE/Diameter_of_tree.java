package TREE;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public class Diameter_of_tree {
    //longes path in a tree;
    //it is not necessary that the root node should be included in our path
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(Diameter_of_tree_brute(root,0));
        int[] max = new int[1];
        int get = height_optimal(root,max);
        System.out.println(max[0]);
    }

    //bruteforce approach;m
    public static int Diameter_of_tree_brute(Node root,int max){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        max = Math.max(lh + rh , max);
        int left = Diameter_of_tree_brute(root.left,max);
        int right = Diameter_of_tree_brute(root.right,max);
        return Math.max(max, Math.max(left,right));
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    //optimal approach
    public static int height_optimal(Node root,int[] max){
        if(root == null){
            return 0;
        }
        int lh = height_optimal(root.left,max);
        int rh = height_optimal(root.right,max);
        max[0] = Math.max(max[0], lh + rh);
        return Math.max(lh, rh ) + 1;
    }
}
