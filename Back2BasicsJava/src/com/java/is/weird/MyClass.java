package com.java.is.weird;

public class MyClass {
    private int var1;
    private int var2;

    public MyClass(){
        this(1);
    }
    public MyClass(int a){
        this(a,2);
    }
    public MyClass(int a, int b){
        
    }

    public int getVar1() {
        return var1;
    }
    public void setVar1(int var1) {
        this.var1 = var1;
    }
    public int getVar2() {
        return var2;
    }
    public void setVar2(int var2) {
        this.var2 = var2;
    }

    

}
