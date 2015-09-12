package com.algos.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by pradeep on 12/09/2015.
 */
public class TreeTraversal {

    class Node<E> {
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
       while(node != null){
           inOrder(node.left);
           System.out.println(node.key);
           inOrder(node.left);
       }
    }

    public static void preOrder(Node node){
        while(node != null){
            System.out.println(node.key);
            inOrder(node.left);
            inOrder(node.left);
        }
    }

    public static void postOrder(Node node){
        while(node != null){
            inOrder(node.left);
            inOrder(node.left);
            System.out.println(node.key);
        }
    }

    public static void levelOrder(Node node){
        if(node == null) return;
        Queue<Node>  level = new LinkedList<>();

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
}
