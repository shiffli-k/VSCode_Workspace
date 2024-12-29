package com.leetcode.medium;

import java.security.InvalidParameterException;



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Part of LeetCode Prodblem: 2181. Merge Nodes in Between Zeros
 */
public class workingWithSingleLinkedList {
    
    // Main Method to test the code
    public static void main(String[] args) {
        Integer[] dataSet1 = { 0, 3, 1, 0, 4, 5, 2, 0 };
        Integer[] dataSet2 = { 0, 1, 0, 3, 0, 2, 2, 0 };
        
        doProcess(dataSet1);
        System.out.println("\n------------");
        doProcess(dataSet2);
        
        
    }

    /**
     * Sample definition provided by leetCode | Merge Nodes in Between Zeros and returns a new Head with the sum of merged.
     * 
     * @param head - The head of the ListNode
     * @return ListNode - The head of the new ListNode containing the merged nodes sum.
     * 
     */
    private static ListNode mergeNodes(ListNode head) {
        // Resulting Node
        ListNode resulListNodeHead = new ListNode(0);
        ListNode resultTravNode = resulListNodeHead;
        boolean firstIteration = true;

        int segmentSum = 0;
        ListNode curTravNode = head;
        do{
            if(curTravNode.val == 0 && (!firstIteration)){
                resultTravNode.next = new ListNode(segmentSum);
                resultTravNode = resultTravNode.next;
                segmentSum=0;
            }else{
                segmentSum+=curTravNode.val;
            }
            firstIteration = false;
            curTravNode = curTravNode.next;
        }while(curTravNode != null);

        return resulListNodeHead.next;
    }

    /**
     * A loopable method to test the code from main()
     * 
     * @param passedDataSet - The Integer[] to be tested
     */
    private static void doProcess(Integer[] passedDataSet){
        ListNode headNode = loadArrayToListNode(passedDataSet);
        
        System.out.println("Input DataSet: ");
        printingOutTheNodes(headNode);
        
        System.out.println("The Output: ");
        printingOutTheNodes(
            mergeNodes(headNode)
        );
    }
    
    /**
     * Another loopable method, this converts the Integer[] to ListNode which I can use for testing
     * @param dataSet - The Integer[] to be converted to ListNode
     * @return ListNode - The head of the ListNode parsed from the passed array.
     * 
     */
    private static ListNode loadArrayToListNode(Integer[] dataSet) {
        if(dataSet.length<1)
            throw new InvalidParameterException("dataSet Array should have altleast one elem");
        ListNode headNode = new ListNode(dataSet[0]);
        ListNode currentNode = headNode;
        for (Integer i = 1; i < dataSet.length; i++) {
            currentNode.next = new ListNode(dataSet[i]);
            currentNode = currentNode.next;
        }
        return headNode;
    }

    /**
     * A recursive method to print out the nodes of the ListNode
     * @param headNode - The head of the ListNode to be printed
     * @return
     * 
     */
    private static ListNode printingOutTheNodes(ListNode headNode) {
        if (headNode == null) {
            // System.out.println("\nNo Nodes Left");
            System.out.println();
            return null;
        }
        System.out.print(headNode.val+" ");
        return printingOutTheNodes(headNode.next);

    }
}
