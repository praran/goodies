package com.algos.trees;

import java.util.*;

/**
 * Created by pradeep on 12/09/2015.
 */
public class TreeTraversal {

    static class Node<E> {
        Node<E> left;
        Node<E> right;
        E key;

        public Node(Node<E> left, E key, Node<E> right){
            this.left=left;
            this.right= right;
            this.key = key;
        }


    }

    public static void inOrder(Node node){
       if(node != null){
           inOrder(node.left);
           System.out.println(node.key);
           inOrder(node.right);
       }
    }

    public static void main(String... args){
        Node<Integer> node0 = new TreeTraversal.Node(null, 2,null);
        Node<Integer> node1 = new TreeTraversal.Node(null, 3,null);
        Node<Integer> node = new TreeTraversal.Node(node0, 1,node1);
       // inOrder(node);

       /* System.out.println(recHeight(node));
       itHeight(node);*/

        System.out.println(findKthMinNode(node,5));

    }

    public static void inOrder2(Node node){

        Stack<Node> stack = new Stack();
        Node curr = node;

        while(!(curr== null && stack.isEmpty())){
            if(curr == null){
                curr = stack.pop();
                System.out.println(curr.key);
                curr= curr.right;
            }else{
                stack.push(curr);
                curr = curr.left;

            }
        }

    }

    public static void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            inOrder(node.left);
            inOrder(node.left);
        }
    }

    public static void postOrder(Node node){
        if(node != null){
            inOrder(node.left);
            inOrder(node.left);
            System.out.println(node.key);
        }
    }

    public static void levelOrder(Node node){
        if(node == null) return;
        Queue<Node>  level = new LinkedList();

        while(!level.isEmpty()){
            Node cur = level.poll();
            System.out.println(cur.key);
            level.add(cur.left);
            level.add(cur.right);
        }
    }

    public static void levelOrder(List<Node> nodes){
        List<Node> list = new ArrayList();
        for(Node node : nodes){
               if(node != null){
                   System.out.println(node.key);
                   list.add(node.left);
                   list.add(node.right);
               }
        }
         if(list.size()>0) levelOrder(list);
    }


    /**
     * Height of the tree
     * @param root
     */
    public static void itHeight(Node root)
    {
        Queue<Node> q = new LinkedList();
        q.add(root);
        int size ;
        int height = 0;
        while(!q.isEmpty())
        {
            size = q.size();
            height++;
            while(size != 0)
            {
                if(q.peek().left != null)
                {
                    q.add(q.peek().left);
                }
                if(q.peek().right != null)
                {
                    q.add(q.peek().right);
                }
                q.remove();
                size--;
            }
        }
        System.out.println("The height of the tree is = "+height);
    }


    public static int recHeight(Node root){
        if (root == null) return 0;
        return Math.max(recHeight(root.left) , recHeight(root.right)) + 1;
    }

    public static Node LCA(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }

        // If the root is one of a or b, then it is the LCA
        if (root == a || root == b) {
            return root;
        }

        Node left = LCA(root.left, a, b);
        Node right = LCA(root.right, a, b);

        // If both nodes lie in left or right then their LCA is in left or right,
        // Otherwise root is their LCA
        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    // kth min node
    // http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/

    public static Integer findKthMinNode(Node<Integer> node, int k){
        if(node ==null){
            return null;
        }

        int n = k;

        Stack<Node> stack = new Stack();
        Node<Integer> curr = node;

        while(!(curr == null && stack.isEmpty())){
            if(curr == null){
                curr  = stack.pop();
                --n;
                if(n == 0){
                    return curr.key;
                }
                curr = curr.right;
            }else{
                stack.push(curr);
                curr = curr.left;
            }
        }
        return null;
    }
}
