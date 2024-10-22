package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slowPointer = n;
        int fastPointer = n;
        while(true){
            slowPointer = movePointer(slowPointer);
            fastPointer = movePointer(fastPointer);
            fastPointer = movePointer(fastPointer);
            if(slowPointer==1 || fastPointer ==1){
                return true;
            }
            if(slowPointer == fastPointer){
                return false;
            }
        }

        // we can also use do while like below.

//        do{
//            slowPointer = movePointer(slowPointer);
//            fastPointer = movePointer(movePointer(fastPointer));
//        } while (slowPointer!=fastPointer);
//        if(slowPointer == 1){
//            return true;
//        }
//        return false;
    }

    private static int movePointer(int num) {
        int sum = 0;
        while(num > 0){
            int digit = num%10;
            num = num/10;
            sum = sum + (digit*digit);
        }
        return sum;
    }
}