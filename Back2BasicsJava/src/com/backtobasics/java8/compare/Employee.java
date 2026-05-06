package com.backtobasics.java8.compare;

public class Employee implements Comparable<Employee>{

    private int emp_id;
    private String emp_name;
    
    // Boilerplate Code | Soup
    public Employee(int emp_id, String emp_name) {
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

    // Comparing two Objects
    //V1
    public boolean isEquals(Employee objectToCompareWith){
        return this.emp_id == objectToCompareWith.emp_id;
    }

    public static boolean isBothEqual(Employee firstObject, Employee secondEmployee){
        return firstObject.emp_id == secondEmployee.emp_id;
    }

    @Override
    public int compareTo(Employee o) {
        if(this.emp_id < o.emp_id)
            return -1;
        else if (this.emp_id > o.emp_id)
            return 1;
        else
            return 0;
    }
    
}
