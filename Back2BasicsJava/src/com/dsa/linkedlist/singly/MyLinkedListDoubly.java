package com.dsa.linkedlist.singly;

class NodeDLL {
    int val;
    NodeDLL prvNode;
    NodeDLL nxtNode;

    NodeDLL(int val, NodeDLL prvNode, NodeDLL nxtNode) {
        this.val = val;
        this.prvNode = prvNode;
        this.nxtNode = nxtNode;
    }
}

/*
 * 
 * AddFirst
 * AddAtIndex
 * AddLast
 * 
 * DeleteFirst
 * DeleteAtIndex
 * DeleteLast
 * 
 * PrintList
 * 
 */

public class MyLinkedListDoubly {
    private NodeDLL HEAD_NODE = null;
    private int sizeOfList = 0;

    public void insertFirst(int valueToInsert) {
        NodeDLL currentNode = null;

        if (HEAD_NODE == null) {
            HEAD_NODE = new NodeDLL(valueToInsert, null, null);
        } else {
            currentNode = HEAD_NODE;
            HEAD_NODE = new NodeDLL(valueToInsert, null, HEAD_NODE);
            currentNode.prvNode = HEAD_NODE;
        }
        ++sizeOfList;
    }

    public void insertAtIndex(int valueToInsert, int indexToInsert) {
        if (indexToInsert > sizeOfList - 1)
            throw new IndexOutOfBoundsException(
                    "Woah there, the list aint that big! | Current Size is: " + getSizeOfList());
        else if (indexToInsert == 0)
            insertFirst(valueToInsert);
        else {
            NodeDLL currentNode = HEAD_NODE;
            currentNode = traverseTillIndex(currentNode, indexToInsert);
            currentNode.nxtNode = new NodeDLL(valueToInsert, currentNode, currentNode.nxtNode);
            currentNode.nxtNode.prvNode = currentNode;
        }
    }

    private NodeDLL traverseTillIndex(NodeDLL passedNode, int indexToReturn) {
        int currentIndex = 0;
        while (currentIndex < indexToReturn - 1) {
            passedNode = passedNode.nxtNode;
            currentIndex++;
        }
        return passedNode;
    }

    private void traverseTillEnd(NodeDLL startingNode) {

    }

    public void printAllNodes() {
        NodeDLL nodePointer = HEAD_NODE;
        if (nodePointer == null) {
            System.out.println("The List is empty!");
            return;
        } else {
            System.out.println("------ List of Values ------");
            while (nodePointer != null) {
                System.out.print(nodePointer.val + " ");
                nodePointer = nodePointer.nxtNode;
            }
            System.out.println("\n------ List of Values | END ------");
        }
    }

    public long getSizeOfList() {
        return sizeOfList;
    }

    public void printSizeOfList() {
        System.out.println("Curent size of DoublyLinkedList is " + getSizeOfList());
        return;
    }

}
