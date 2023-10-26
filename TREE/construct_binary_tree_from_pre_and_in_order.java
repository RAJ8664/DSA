package TREE;


//class Node{
//    int data;
//    Node left;
//    Node right;
//    public Node(int data){
//        this.data = data;
//        left = right = null;
//    }
//}

import java.util.HashMap;
import java.util.Scanner;

public class construct_binary_tree_from_pre_and_in_order {
    //make sure to check whether we can make a unique binary tree from pre && post  || in && pre || in && post
    //we can make unique binary tree only in case of in && pre  and in && post

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        Node root = Build_Tree(preorder, inorder);
        System.out.println(root);
    }

    public static Node Build_Tree(int preorder[], int inorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node root = Build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public static Node Build(int preorder[], int prestart, int preend, int indorder[], int instart, int inend, HashMap<Integer, Integer> map) {
        if (prestart > preend || instart > inend) return null;

        Node root = new Node(preorder[prestart]);
        int inroot = map.get(root.data);
        int numleft = map.get(root.data) - instart;

        root.left = Build(preorder, prestart + 1, prestart + numleft, indorder, instart, inroot - 1, map);
        root.right = Build(preorder, prestart + numleft + 1, preend, indorder, inroot + 1, inend, map);
        return root;
    }
}
