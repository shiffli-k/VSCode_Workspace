package com.dsa.linkedlist;

import java.util.Random;

import com.dsa.linkedlist.singly.MyLinkedList;
import com.dsa.linkedlist.singly.MyLinkedListDoubly;

public class UsingMyLinkedList {

    /*
     * Add a method to insert a node at a specific position.
     * Add a method to delete a node (by value or position).
     * Implement a method to reverse the linked list.
     * 
     */

    public static void main(String[] args) {

        // usingMySingleLinkedList();
        usingDoublyLinkedList();

    }

    private static void usingDoublyLinkedList() {
        MyLinkedListDoubly lst1 = new MyLinkedListDoubly();
        lst1.insertFirst(4);
        lst1.insertFirst(3);
        lst1.insertFirst(2);
        lst1.insertFirst(1);
        lst1.printAllNodes();
        lst1.insertAtIndex(99, 0);
        lst1.printAllNodes();
    }

    private static void usingMySingleLinkedList() {
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

    private static void loadMyLinkedList(int limit, MyLinkedList passedLinkedList) {
        for (int i = 0; i < limit; i++) {
            passedLinkedList.addElement(new Random().nextInt(1, 1000));
        }
        return;
    }
}
