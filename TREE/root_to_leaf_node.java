package TREE;

import java.util.ArrayList;

public class root_to_leaf_node {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = root_to_leaf(root);
        for(ArrayList<Integer> current : ans){
            for(int i = 0; i < current.size(); i++){
                System.out.print(current.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> root_to_leaf(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(root,new ArrayList<>(),ans);
        return ans;
     }
    public static void solve(Node root,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        if(root == null) return;
        temp.add(root.data);
        if(root.left == null && root.right == null) {
            ans.add(new ArrayList<>(temp));
        }
        solve(root.left,temp,ans);
        solve(root.right,temp,ans);
        temp.remove(temp.size() - 1);
    }
}
