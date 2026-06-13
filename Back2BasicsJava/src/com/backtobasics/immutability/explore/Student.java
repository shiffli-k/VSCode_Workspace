package com.backtobasics.immutability.explore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private int stdID;
    private String stdName;
    private List<String> stdCourseList;
    
    /**
     * 
     * Bad Constructor, accepts already built object and keeps the reference
     * 
     * @param stdID
     * @param stdName
     * @param cources - accepts a already built object
     * 
     */
    public Student(int stdID, String stdName, List<String> cources) {
        this.stdID = stdID;
        this.stdName = stdName;
        
        // Below breaks encapsulation
        this.stdCourseList = cources;

        // Below enforces encapsulation
        // this.stdCourseList = new ArrayList<>(cources);
    }

    /**
     * 
     * Another way of ensuring encapsulation. GetValues and built ourselves.
     * 
     * @param id
     * @param nameOfStudent
     * @param courses
     */
    public Student(int id, String nameOfStudent, String... courses){
        this.stdID = id;
        this.stdName = nameOfStudent;

        stdCourseList = new ArrayList<>();
        for(String eachCourseListed : courses)
            stdCourseList.add(eachCourseListed);

    }

    public int getStdID() {
        return stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public List<String> getStdCourseList() {

        // below breaks encapsulation - Object reference is shared
        // return stdCourseList;

        // Below enforces encapsulation - A copy of it is shared
        return Collections.unmodifiableList(this.stdCourseList);
    }

    @Override
    public String toString() {
        return "Student [stdID=" + stdID + ", stdName=" + stdName + ", stdCourseList=" + stdCourseList.toString() + "]";
    }

    
    
}
