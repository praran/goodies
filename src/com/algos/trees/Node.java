package com.algos.trees;

/**
 * Created by pradeep on 12/09/2015.
 */
public class Node<E> implements  Tree<E> {
    Tree<E> left , right;
    E key;

    public Node(Tree<E> left, E k , Tree<E> right){
        this.left =left;
        this.right = right;
        this.key = k;
    }

    @Override
    public int size() {
        return left.size() + 1 + right.size();
    }
}
