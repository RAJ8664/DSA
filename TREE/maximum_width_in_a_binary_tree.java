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

import java.util.LinkedList;
import java.util.Queue;

class PPair{
    Node node;
    int index;
    public PPair(Node node ,int index){
        this.node = node;
        this.index = index;
    }
}
public class maximum_width_in_a_binary_tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(solve(root));
    }


    //remember here the null nodes are also considered;
    //if the null nodes are not considered then it is so easy
    //just apply bfs and keep track of maximum nodes at any particular level;


    public static int solve(Node root){
        if(root == null) return 0;
        Queue<PPair> q = new LinkedList<>();
        q.offer(new PPair(root, 0));
        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();
            int mini = q.peek().index;
            int last = 0;
            int first = 0;
            for(int i = 0; i < len; i++){
                PPair curr = q.poll();
                Node node = curr.node;
                int ind = curr.index;
                if(i == 0) first = ind;
                if(i == len - 1) last = ind;
                int currind = i - mini;
                if(node.left != null) q.offer(new PPair(node.left, 2 * currind + 1));
                if(node.right != null) q.offer(new PPair(node.right,2 * currind + 2));

            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }

    //if null nodes are not cosidered in our anwer;
    public static int easy_solve(Node root){
        if(root == null) return 0;
        int ans = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                q.poll();
            }
            ans = Math.max(ans,q.size());
        }
        return ans;
    }
}
