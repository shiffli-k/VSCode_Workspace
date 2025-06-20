package com.dsa.tree.mytree.nodestruct;

public class BTNode<E> {

    public E value;
    public BTNode<E> leftNode, rightNode;

    public BTNode(E nodeValue){
        this.value = nodeValue;
    }

}
