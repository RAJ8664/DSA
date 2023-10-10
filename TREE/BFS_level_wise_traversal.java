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

public class BFS_level_wise_traversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new  Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right =new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<List<Integer>> ans = new LinkedList<>();
        ans = BFS(root);
        for(List<Integer> current : ans) {
            for (int i = 0; i < current.size(); i++) {
                System.out.print(current.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> BFS(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < len; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                temp.add(q.poll().data);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
