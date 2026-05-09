package com.java.is.weird;

import java.lang.classfile.constantpool.IntegerEntry;

public class MyEmp{

    private int emp_id;
    private String emp_name;
    
    // Boilerplate Code | Soup
    public MyEmp(int emp_id, String emp_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }

    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    public String getEmp_name() {
        return emp_name;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    // Boilerplate code | Soup | ENDS


    
    // ToString
    @Override
    public String toString() {
        return "MyEmp [emp_id=" + emp_id + ", emp_name=" + emp_name + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if(!(obj instanceof MyEmp))
            return false;

        return this.emp_id == ((MyEmp)obj).emp_id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(emp_id);
    }

    
}
