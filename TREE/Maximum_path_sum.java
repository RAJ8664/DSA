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

public class Maximum_path_sum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        solve(root,max);
        System.out.println(max[0]);
    }

    public static int solve(Node root, int[] max){
        if(root == null){
            return 0;
        }
        int left = Math.max(0 , solve(root.left ,max));
        int right = Math.max(0 , solve(root.right ,max));
        max[0] = Math.max(max[0] , root.data + left + right);
        return Math.max(left , right ) + root.data;
    }
}
