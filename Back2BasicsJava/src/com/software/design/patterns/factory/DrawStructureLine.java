package com.software.design.patterns.factory;

import com.software.design.patterns.factory.definition.DrawStructure;

public class DrawStructureLine implements DrawStructure{

    protected DrawStructureLine(){

    }

    @Override
    public void drawStruct() {
        System.out.println("__________________");
    }
    public void drawStruct(int length){
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void doSomethingElse(){
        System.out.println("SomethingElse");
    }

}
