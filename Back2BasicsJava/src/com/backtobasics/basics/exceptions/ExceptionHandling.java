package com.backtobasics.basics.exceptions;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int arr[] = { 1, 2, 3 };
            // arr[0] = arr[4];
            if (true) {
                throw new CantDoThatClass("This Bad");
            }
        } catch (NullPointerException ne) {
            System.err.println("Exception Occured");
            ne.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.err.println("There goes index");
            ae.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}

class CantDoThatClass extends Throwable {

    public CantDoThatClass() {
        super("Something bad Occured");
    }

    public CantDoThatClass(String errorText) {
        super(errorText);
    }

}