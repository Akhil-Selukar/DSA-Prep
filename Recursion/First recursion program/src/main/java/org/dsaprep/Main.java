package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        printNumber(1);
    }

    /*private static void printNumber(int n) {
        System.out.println(n);
        printNumber1(n+1);
    }

    private static void printNumber1(int n) {
        System.out.println(n);
        printNumber2(n+1);
    }

    private static void printNumber2(int n) {
        System.out.println(n);
        printNumber3(n+1);
    }

    private static void printNumber3(int n) {
        System.out.println(n);
        printNumber4(n+1);
    }

    private static void printNumber4(int n) {
        System.out.println(n);
    }*/

//    Here in above program we can see that we are repeating same code multiple times. ANd all the function calls inside the function
//    has same body except the last printNumber4 function. We can rewrite the above code using recursion like below.

    private static void printNumber(int n) {
        System.out.println(n);
        if(n==5){
            return;
        }
        printNumber(n+1);
    }

}