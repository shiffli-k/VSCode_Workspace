package com.dsa.array;

import java.util.Random;

public class UsingMyLinkedList {

    /*
     * Add a method to insert a node at a specific position.
     * Add a method to delete a node (by value or position).
     * Implement a method to reverse the linked list.
     * 
     */

    public static void main(String[] args) {

        MyLinkedList l1 = new MyLinkedList();

        // l1.addElement(1).addElement(2).addElement(4).addElement(5);
        loadMyLinkedList(6, l1);

        l1.insertAt(0, 101);
        l1.printAllNodes();
        l1.deleteNodeAt(6);
        l1.printAllNodes();
        l1.reverseIt();
        l1.printAllNodes();
    }

    private static void loadMyLinkedList(int limit, MyLinkedList passedLinkedList){
        for (int i = 0; i < limit; i++) {
            passedLinkedList.addElement(new Random().nextInt(1,1000));
        }
        return;
    }
}
