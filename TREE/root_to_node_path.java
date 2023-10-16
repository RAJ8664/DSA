package TREE;

import java.util.ArrayList;

public class root_to_node_path {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = get_path_to_node(root,6);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> get_path_to_node(Node root,int val){
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root,val,new ArrayList<>(),ans);
        return ans;
    }

    public static void solve(Node root,int val,ArrayList<Integer> temp,ArrayList<Integer> ans){

       if(root == null) return;
       temp.add(root.data);
       if(root.data == val) {
           for(int i = 0; i < temp.size(); i++){
               ans.add(temp.get(i));
           }
       }
       solve(root.left,val,temp,ans);
       solve(root.right,val,temp,ans);
       temp.remove(temp.size() - 1);
    }
}
