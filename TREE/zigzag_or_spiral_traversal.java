package TREE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class zigzag_or_spiral_traversal {
    //read the problem statement;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<List<Integer>> ans  = new ArrayList<>();
        ans = zigzag_traversal(root);
        for(List<Integer> current : ans){
            for(int i = 0; i < current.size(); i++){
                System.out.print(current.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzag_traversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int len = q.size();
            ArrayList<Integer> temp = new ArrayList<>(len);
            for(int i = 0; i < len; i++){
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                if(flag == true){
                    temp.add(q.poll().data);
                }
                else{
                    temp.add(0, q.poll().data);
                }
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }
}
