package com.algos.trees;

/**
 * Created by pradeep on 12/09/2015.
 */
public class BinaryTree<E> {
     class Node{
        Node left;
        E key;
        Node right;

        Node(Node node){
            this.left= node.left;
            this.right = node.right;
            this.key = node.key;
        }
        Node(Node left, E k, Node right){
            this.left = left;
            this.right = right;
            this.key = k;
        }
    }

    Node root;

    public BinaryTree(){}

    public void setNode(Node node){
        this.root = node;
    }

    private int size(Node tree){
        return tree == null ? 0 : size(tree.left) + 1 + size(tree.right);
    }

    public int size(){
        return this.size(root);
    }

    public static void main(String... args){
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node n = tree.new Node(null, 1, null);
        tree.setNode(n);
        System.out.println(tree.size());
    }
}
