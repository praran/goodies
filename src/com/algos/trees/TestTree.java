package com.algos.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pradeep on 12/09/2015.
 */
public class TestTree {

    public static void main(String... args){
        Node<Integer> node0 = new Node(new Empty<Integer>(), 4, new Empty<>());
        Node<Integer> node1 = new Node(node0, 1, new Empty<>());
        Node<Integer> node2 = new Node(new Empty<Integer>(), 3, new Empty<>());

        Tree<Integer> tree = new Node(node1, 2, node2);

        System.out.println(tree.size());
        inOrderTraverse(tree);
        inOrderTraversal(tree);

    }

    public static void levelOrder(){

    }

    /**
     * Brilliant simple level order in java
     * @param node
     */
     public static void levelOrder(Tree node){
         if(node instanceof  Empty)
             System.out.println("");
         Queue<Node> level = new LinkedList<>();
         level.add((Node) node);
         while(!level.isEmpty()){
             Node n =level.poll();
             System.out.println(n.key);
             if(n.left instanceof  Node)
                level.add((Node) n.left);
             if(n.right instanceof Node)
                 level.add((Node) n.right);
         }

     }

    // iterative without stack

    public static void inorder(Tree tree){
        if(tree instanceof Empty) return;
        Node cur = (Node)tree;
        while(cur instanceof  Node){
            if(cur.left instanceof  Empty){
                System.out.println(cur.key);
                if(cur.right instanceof Node)
                cur = (Node) cur.right;
            }else{
                if(cur.left instanceof Node){
                    Node pre = (Node) cur.left;
                    while(pre.right instanceof  Node && pre.right != cur){

                    }
                }



            }
        }
    }

    // Recursive implementation
    public static void inOrderTraversal(Tree tree){

        if(tree instanceof Node){
            inOrderTraversal(((Node) tree).left);
            System.out.println(((Node) tree).key);
            inOrderTraversal(((Node) tree).right);
        }
    }

    // Iterative
    public static void inOrderTraverse(Tree tree){
        Stack<Node> stack = new Stack<Node>();
        Tree cur = tree;

        while(!(cur ==null && stack.isEmpty())){
            if(cur instanceof Node){
                if(cur instanceof Empty){
                    cur = stack.pop();
                    System.out.println(((Node)cur).key);
                    cur = ((Node) cur).right;
                }else{
                    stack.push((Node)cur);
                    cur = ((Node)cur).left;
                }
            }

        }

    }


}
