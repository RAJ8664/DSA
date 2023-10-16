package TREE;
import java.util.*;

//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int d){
//        this.data = d;
//        left = right = null;
//    }
//}

class Tuple{
    Node node;
    int vertical;
    int level;
    public Tuple(Node node, int vertical , int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
public class vertical_order_traversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = vertical_order(root);
        for(ArrayList<Integer> current : ans){
            for(int i = 0; i < current.size(); i++){
                System.out.print(current.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> vertical_order(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0 , 0));
        while(!q.isEmpty()){
            Tuple t= q.poll();
            Node node = t.node;
            int vertical = t.vertical;
            int level = t.level;
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level,new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(node.data);
            if(node.left != null) q.offer(new Tuple(node.left,vertical - 1, level + 1));
            if(node.right != null) q.offer(new Tuple(node.right,vertical + 1, level + 1));
        }

        for(Map.Entry<Integer, TreeMap<Integer,PriorityQueue<Integer>>>  entry1 : map.entrySet()){
            TreeMap<Integer,PriorityQueue<Integer>> itm = entry1.getValue();
            ArrayList<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> entry2 : itm.entrySet()){
                PriorityQueue<Integer> pq = entry2.getValue();
                while(!pq.isEmpty()){
                    temp.add(pq.poll()) ;
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
