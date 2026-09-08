package com.leetcode.medium;

import java.util.Arrays;

public class MinStack {

    public static void main(String[] args) {

        MinStack tst = new MinStack();
        
        IO.println(Arrays.toString(tst.stackMemory) + " | " +Arrays.toString(tst.minStackMemory) + " Top is at " + tst.top);
        
        tst.push(1);
        tst.push(2);
        tst.push(0);
        
        IO.println(Arrays.toString(tst.stackMemory) + " | " +Arrays.toString(tst.minStackMemory) + " Top is at " + tst.top);

        IO.println(tst.getMin()); // return 0
        tst.pop();
        IO.println(tst.top());    // return 2
        IO.println(tst.getMin()); // return 1
        
    }

    private static final double SCALE_BY_PERCENT = 1.25D; // i.e. 25% Scale

    private int[] stackMemory;
    private int[] minStackMemory;
    private int top = 0;


    private void scaleArray(){
        int currentSize = stackMemory.length;
        int updateSize = (int) (currentSize * SCALE_BY_PERCENT);
        
        IO.println("Scaling from + " + currentSize + " to Size: " + updateSize);

        this.stackMemory = Arrays.copyOf(stackMemory, updateSize);
        this.minStackMemory = Arrays.copyOf(minStackMemory, updateSize);
    }


    public MinStack() {
        // init
        this.stackMemory = new int[15];
        this.minStackMemory = new int[15];
        
        this.minStackMemory[0] = Integer.MAX_VALUE;
    }
    
    public void push(int val) {

        // Check and update Min
        int currentMin;

        if(top == 0){
            currentMin = Integer.MAX_VALUE;
        }else{
            currentMin = this.minStackMemory[this.top-1];
        }

        boolean isCurrentValSmol = val < currentMin;

        if(top == this.stackMemory.length){
            scaleArray();
        }
        
        this.stackMemory[top] = val;

        if(isCurrentValSmol){
            this.minStackMemory[top] = val;
        }else{
            this.minStackMemory[top] = currentMin;
        }

        top++;
    }
    
    public void pop() {
        --top;
    }
    
    public int top() {
        
        return this.stackMemory[top-1];
    }
    
    public int getMin() {
        return this.minStackMemory[top-1];
        // return smallest element in stack?
        // return this.stackMemory[0];

    }

}
