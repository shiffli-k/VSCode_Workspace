package com.dsa.tree.mytree;

import com.dsa.tree.mytree.nodestruct.BTNode;

public class BSTree<T extends Comparable<T>> {
    
    private BTNode<T> rootNode;

    public BTNode<T> getRootNode(){
        return this.rootNode;
    }
    
    //Insertion
    public void addValue(T valueToAdd){
        System.out.println("Adding element to Tree: " + valueToAdd);
        if(rootNode == null)
            rootNode = new BTNode<T>(valueToAdd);
        else
            addValRecurse(rootNode, valueToAdd);
        return;
    }

    private BTNode<T> addValRecurse(BTNode<T> currentNode, T valueToAdd){
        if(currentNode == null)
            return new BTNode<T>(valueToAdd);
        if(valueToAdd.compareTo(currentNode.value) < 0)
            currentNode.leftNode = addValRecurse(currentNode.leftNode, valueToAdd);
        if(valueToAdd.compareTo(currentNode.value) > 0)
            currentNode.rightNode = addValRecurse(currentNode.rightNode, valueToAdd);
        return currentNode;
    }

    //Contains

    public boolean findValue(T valueToSearch){
        
        return recurseFindValue(this.rootNode, valueToSearch, false);
    }

    private boolean recurseFindValue(BTNode<T> currentNode, T valueToSearch, boolean isFound) {
        if (currentNode == null) {
            return isFound;
        }

        if(valueToSearch.compareTo(currentNode.value) < 0)
            isFound = recurseFindValue(currentNode.leftNode, valueToSearch, isFound);
        else if(valueToSearch.compareTo(currentNode.value) > 0)
            isFound = recurseFindValue(currentNode.rightNode, valueToSearch, isFound);
        else if (valueToSearch.compareTo(currentNode.value) == 0)
            isFound = true;
        
        return isFound;
    }

    //Min & Max
    public T getMinValue(){
        return findMinRecurse(this.rootNode);
    }

    private T findMinRecurse(BTNode<T> passedNode) {
        T minValue = passedNode.value;
        if(passedNode.leftNode != null && (passedNode.leftNode.value.compareTo(minValue) < 0))
            minValue = findMinRecurse(passedNode.leftNode);
        return minValue;
    }

    public T getMaxValue(){
        return findMaxRecurse(this.rootNode);
    }

    private T findMaxRecurse(BTNode<T> passedNode) {
        T maxValue = passedNode.value;
        if(passedNode.rightNode != null && (passedNode.rightNode.value.compareTo(maxValue) > 0))
            maxValue = findMaxRecurse(passedNode.rightNode);
        return maxValue;
    }
    
    //Hi-eight
    private int maxHeight;
    private int currentHeight;
    public int getHeightOfTree(){
        maxHeight = currentHeight = 1;
        findHeightRecirse(rootNode);
        return maxHeight;
    }

    private void findHeightRecirse(BTNode<T> passedNode) {
        if(currentHeight > maxHeight) maxHeight = currentHeight;

        if(passedNode.leftNode != null){
            ++currentHeight;
            findHeightRecirse(passedNode.leftNode);
        }
        if(passedNode.rightNode !=null){
            ++currentHeight;
            findHeightRecirse(passedNode.rightNode);
        }
        --currentHeight;
    }
        
    //Remove - YIKES
    public void removeValue(T valueToRemove) {
        removeGivenValueRecurse(valueToRemove, rootNode);
    }

    private BTNode<T> removeGivenValueRecurse(T valueToRemove, BTNode<T> currentNode) {

        int curValCompare = currentNode.value.compareTo(valueToRemove);

        if(curValCompare < 0){
            currentNode.leftNode = removeGivenValueRecurse(valueToRemove, currentNode);
        }else if (curValCompare > 1){
            currentNode.rightNode = removeGivenValueRecurse(valueToRemove, currentNode);
        }else if (curValCompare == 0){
            
        }

        return currentNode;
    }

    
}
