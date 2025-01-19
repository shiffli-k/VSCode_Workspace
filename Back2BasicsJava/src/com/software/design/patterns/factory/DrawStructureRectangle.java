package com.software.design.patterns.factory;

import com.software.design.patterns.factory.definition.DrawStructure;

public class DrawStructureRectangle implements DrawStructure {

    protected DrawStructureRectangle(){

    }

    @Override
    public void drawStruct() {
        String aLine = "__________________";
        System.out.println(aLine);
        
        for (int i = 0; i < aLine.length()/2; i++) {
            System.out.println("|" + aLine.replace("_", " ") + "|");
        }
        
        System.out.println(aLine);
    }

}
