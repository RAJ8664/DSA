package TREE;


//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        left = right = null;
//    }
//}

public class lowest_common_ancestor {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(LCA(root,root.left,root.right).data);
    }

    public static Node LCA(Node root,Node p,Node q){
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = LCA(root.left,p,q);
        Node right = LCA(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        //if both are not null return root;
        return root;
    }
}
