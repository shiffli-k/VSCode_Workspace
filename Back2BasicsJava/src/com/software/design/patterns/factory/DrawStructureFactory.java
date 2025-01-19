package com.software.design.patterns.factory;

import com.software.design.patterns.factory.definition.DrawStructure;

public class DrawStructureFactory {

    private DrawStructureFactory(){

    }

    // Good but not great way to use
    public static final String LINE_STRUCTURE = "line";
    public static final String SQUARE_STRUCTURE = "square";
    public static final String RECTANGLE_STRUCTURE = "rectangle";

    // Better way
    public static enum useStructure{
        Line, Square, Rectange;
    }
    
    @Deprecated
    public static DrawStructure getStructure(String nameOfShape){
        if("line".equalsIgnoreCase(nameOfShape))
            return new DrawStructureLine();
        else if("square".equalsIgnoreCase(nameOfShape))
            return new DrawStructureSquare();
        else if("rectangle".equalsIgnoreCase(nameOfShape))
            return new DrawStructureRectangle();
        else
            throw new UnsupportedOperationException("The Shape: " + nameOfShape + " does not exist. Atleast not in my class anyway :)");

    }
    
    public static DrawStructure getStructure(useStructure requestedStructure){
        switch (requestedStructure) {
            case Line:
                return new DrawStructureLine();
            case Square:
                return new DrawStructureSquare();
            case Rectange:
                return new DrawStructureRectangle();
            default:
                return null;
        }
    }
}
