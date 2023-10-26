package TREE;


//class Node{
//    int data;
//    Node left;
//    Node rigth;
//    public Node(int d){
//        this.data = d;
//        left = right = null;
//    }
//}

import java.util.HashMap;
import java.util.Scanner;
public class construct_binary_tree_from_in_and_post_order {
    //Read the problem first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inorder[] = new int[n];
        int postorder[] = new int[n];
        for(int i = 0; i < n; i++){
            inorder[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            postorder[i] = sc.nextInt();
        }
        Node root = Build_Tree(inorder,postorder);
        System.out.println(root);
    }

    public static Node Build_Tree(int inorder[],int postorder[]){
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i] , i);
        }
        Node root = Build(postorder,0,n - 1, inorder, 0 , n - 1, map);
        return root;
    }
    public static Node Build(int postorder[],int poststart, int postend, int inorder[],int instart, int inend, HashMap<Integer,Integer> map){
        if(poststart > postend || instart > inend) return null;
        Node root = new Node(postorder[postend]);
        int inroot = map.get(root.data);
        int numleft = inroot - instart;

        root.left = Build(postorder,poststart, poststart + numleft - 1,inorder, instart , inroot - 1, map);
        root.right = Build(postorder, poststart + numleft,postend - 1, inorder, inroot + 1, inend, map);
        return root;
    }
}
