package com.dsa.patterns.arrays;

import java.util.Random;

class SLLNode {
    int nodeValue;
    SLLNode nextNode;

    SLLNode(int nodeValue) {
        this.nodeValue = nodeValue;
        this.nextNode = null;
    }
}

public class LinkedListFastSlowPointer {

    static SLLNode headNode = null;
    public static void main(String[] args) {
        loadListWithRandoVal(10);
        printNodes();
        causeALoopOnAccident();
        // printNodes(); // Bad Idea mate!
        if(hasLoop()){
            System.out.println("LL has a loop!"); 
            straightenIt();
            printNodes();
        }else{
            System.out.println("LL is straight :P"); 
        }
    }

    private static void straightenIt() {
        SLLNode rabbitNode = headNode;
        SLLNode turtleNode = headNode;
        SLLNode prevNode;
        boolean loopState= true;
            do {
                rabbitNode = rabbitNode.nextNode.nextNode;
                turtleNode = turtleNode.nextNode;
                if(rabbitNode == turtleNode){
                    loopState = true;
                    break;
                }
            } while (turtleNode != null);

        if(loopState){
            rabbitNode=headNode;
            prevNode=turtleNode;
            while (rabbitNode != turtleNode) {
                prevNode = turtleNode;
                rabbitNode = rabbitNode.nextNode;
                turtleNode = turtleNode.nextNode;
            }
            prevNode.nextNode=null;
        }
    }

    private static boolean hasLoop() {
        SLLNode rabbitNode = headNode;
        SLLNode turtleNode = headNode;
        try {            
            do {
                rabbitNode = rabbitNode.nextNode.nextNode;
                turtleNode = turtleNode.nextNode;
                if(rabbitNode == turtleNode)
                    return true;
            } while (turtleNode != null);
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private static void causeALoopOnAccident() {
        if(headNode == null)
            System.out.println("Head is Null");
        int positionToLoopOn = 4;
        int currentIteration = 1;
        SLLNode loopOnNode=null;
        SLLNode currentnode=headNode;

        do {
            if (currentIteration == positionToLoopOn) {
                loopOnNode = currentnode;
            }
            currentnode = currentnode.nextNode;
            ++currentIteration;
        } while (currentnode.nextNode != null);

        currentnode.nextNode=loopOnNode;

    }

    private static void printNodes() {
        if (headNode == null)
            System.out.println("List is empty");

        System.out.println("--PrintingList--");
        SLLNode currentNode = headNode;
        do {
            System.out.print(currentNode.nodeValue + "->");
            currentNode = currentNode.nextNode;
        } while (currentNode.nextNode != null);
        System.out.println("\n--PrintingListComplete--");
    }

    private static void loadListWithRandoVal(int sizeToLoad) {
        if (sizeToLoad < 1)
            return;
        headNode = new SLLNode(new Random(sizeToLoad).nextInt(1, 99));
        SLLNode currentNode = headNode;
        for (int i = 1; i < sizeToLoad; i++) {
            currentNode.nextNode = new SLLNode(new Random().nextInt(1, 99));
            currentNode = currentNode.nextNode;
        }
    }
}
