package com.dsa.tree.mytree;

import com.dsa.tree.mytree.nodestruct.BTNode;

public class TryingOutMyTrees {

    public static void main(String[] args) {

        // plainOldBinaryTree();
        meVeryOwnBSTree();

    }
    
    private static void meVeryOwnBSTree() {
        BSTree<Integer> bst = new BSTree<>();
        bst.addValue(4);
        bst.addValue(1);
        bst.addValue(2);
        bst.addValue(0);
        bst.addValue(10);
        bst.addValue(12);
        bst.addValue(13);
        bst.addValue(14);
        
        TraverseBT.printPreOrder(bst.getRootNode());
        System.out.println("----");
        TraverseBT.printInOrder(bst.getRootNode());
        System.out.println("----");
        System.out.println("Is Value 4 Found: " + bst.findValue(4));
        System.out.println("Is Value 0 Found: " + bst.findValue(0));
        System.out.println("Is Value 10 Found: " + bst.findValue(10));
        System.out.println("Is Value 9 Found: " + bst.findValue(9));
        System.out.println("----");
        System.out.println("Min Value in Tree is: " + bst.getMinValue());
        System.out.println("Max Value in Tree is: " + bst.getMaxValue());
        System.out.println("----");
        System.out.println("Max Height of Tree is: " + bst.getHeightOfTree());
        bst.addValue(15);
        bst.addValue(16);
        System.out.println("Max Height of Tree is: " + bst.getHeightOfTree());
        System.out.println("----");
        bst.removeValue(13);
        System.out.println("----");

    }
    
    private static void plainOldBinaryTree() {
        BTNode<Integer> rootNode = new BTNode<Integer>(10);
    
        rootNode.leftNode = new BTNode<Integer>(1);
        rootNode.rightNode = new BTNode<Integer>(11);
        rootNode.leftNode.leftNode = new BTNode<Integer>(2);
        rootNode.leftNode.rightNode = new BTNode<Integer>(3);
    
        System.out.println("\n-- PreOrder --");
        TraverseBT.printPreOrder(rootNode);
        
        System.out.println("\n-- PostOrder --");
        TraverseBT.printPostOrder(rootNode);
    
        System.out.println("\n-- InOrder --");
        TraverseBT.printInOrder(rootNode);
    }

}