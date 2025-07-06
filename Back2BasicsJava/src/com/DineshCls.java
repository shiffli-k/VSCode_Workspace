package com;

public class DineshCls 
{

    public static void main(String[] args) 
    {

        int a = 2;
        
        boolean b = true;

        isEvenNumber(a);

        System.out.println("Number is " + b);
        
    }

    public static void isEvenNumber(int a){
        if(a % 2 == 0){
            System.out.println("Its is a Even number");
        }
        else{
            System.out.println("Its is an odd number");
        }
    }
    
    

}
