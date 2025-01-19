package com.software.design.patterns.factory;

import com.software.design.patterns.factory.definition.DrawStructure;

public class DrawStructureSquare implements DrawStructure {

    protected DrawStructureSquare(){

    }

    @Override
    public void drawStruct() {
        String aLine = "__________________";
        System.out.println(aLine);
        for (int i = 0; i < aLine.length(); i++) {
            System.out.println("|" + aLine.replace("_", " ") + "|");
        }
        System.out.println(aLine);
    }

}
