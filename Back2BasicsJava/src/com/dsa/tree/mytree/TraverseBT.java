package com.dsa.tree.mytree;

import com.dsa.tree.mytree.nodestruct.BTNode;

public class TraverseBT {

    public static <E> void printPreOrder(BTNode<E> rootNode){
        System.out.println("Printing Tree - PreOrder");
        recCallPre(rootNode);
        System.out.println("Printing Tree - Complete");
        return;
    }
    public static <E> void printPostOrder(BTNode<E> rootNode){
        System.out.println("Printing Tree - PostOrder");
        recCallPost(rootNode);
        System.out.println("Printing Tree - Complete");
        return;
    }
    public static <E> void printInOrder(BTNode<E> rootNode){
        System.out.println("Printing Tree - InOrder");
        recCallIn(rootNode);
        System.out.println("Printing Tree - Complete");
        return;
    }

    private static <E> void recCallPre(BTNode<E> currentNode){
        if(currentNode == null) return;

        System.out.println("\t - " + currentNode.value);
        recCallPre(currentNode.leftNode);
        recCallPre(currentNode.rightNode);
    }

    private static <E> void recCallPost(BTNode<E> currentNode){
        if(currentNode == null) return;

        recCallPost(currentNode.leftNode);
        recCallPost(currentNode.rightNode);
        System.out.println("\t - " + currentNode.value);
    }

    private static <E> void recCallIn(BTNode<E> currentNode){
        if(currentNode == null) return;

        recCallIn(currentNode.leftNode);
        System.out.println("\t - " + currentNode.value);
        recCallIn(currentNode.rightNode);
    }
}
