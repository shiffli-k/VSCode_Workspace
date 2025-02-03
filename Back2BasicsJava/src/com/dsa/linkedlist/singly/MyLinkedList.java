package com.dsa.linkedlist.singly;

class Node {
    int value;
    Node nextNode;

    Node(int nodeValue) {
        this.value = nodeValue;
        nextNode = null;
    }
}

public class MyLinkedList {
    private Node node_Head = null;
    private Node node_LastInserted = null;

    public MyLinkedList addElement(int elementToAdd) {
        Node currentNode = new Node(elementToAdd);

        // Setting up nodes, if first Node
        if (node_Head == null)
            node_Head = currentNode;
        if (node_LastInserted == null)
            node_LastInserted = currentNode;

        // Pointing Current Node with CurrentNode-1's nextNode
        node_LastInserted.nextNode = currentNode;

        // Updating lastInserted Node
        node_LastInserted = currentNode;

        return this;
    }

    public void printAllNodes() {
        Node currentNode = node_Head;
        int coutner = 1;
        System.out.println("------Printing MyList------");
        while (currentNode != null) {
            System.out.println("Node " + (coutner++) + " has Value " + currentNode.value);
            currentNode = currentNode.nextNode;
        }
        System.out.println("------Printing MyList | Completed------\n");
        return;
    }

    public void deleteNodeAt(int nodeIndexToDelete) {

        if (nodeIndexToDelete == 0) {
            node_Head = node_Head.nextNode;
            return;
        }

        Node currentNode = node_Head;
        Node prevNode = node_Head;

        for (int i = 0; currentNode != null; i++) {
            if (i == nodeIndexToDelete) {
                // Node found, Drop the node
                prevNode.nextNode = currentNode.nextNode;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        return;
    }

    public void insertAt(int insertionIndex, int valueToInsert) {

        if (insertionIndex == 0) {
            Node newHeadNode = new Node(valueToInsert);
            newHeadNode.nextNode = node_Head;
            node_Head = newHeadNode;
            return;
        }

        Node currentNode = node_Head;
        for (int i = 1; currentNode != null; i++) {
            if (i == insertionIndex) {
                Node insertedNode = new Node(valueToInsert);
                insertedNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = insertedNode;
                break;
            } else {
                currentNode = currentNode.nextNode;
            }
        }
        return;
    }

    public void reverseIt() {
        Node node_Previous = null;
        Node node_Current = node_Head;
        Node node_Next = node_Current.nextNode;

        while (node_Current != null) {
            // Point Current Node to Previous node
            node_Current.nextNode=node_Previous;

            if(node_Next == null){
                node_Head = node_Current;
                break;
            }
            
            // Traverse
            node_Previous = node_Current;
            node_Current = node_Next;
            node_Next = node_Next.nextNode;


        }

    }

}
