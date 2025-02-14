package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution 1 - With stack - (O(N)/O(N))
//    public int calculate(String s) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//
//        s = s.replaceAll(" ","");
//        System.out.println(s);
//        int num = 0;
//        char operation = '+';
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i=0; i<s.length(); i++){
//            char ch = s.charAt(i);
//
//            if(Character.isDigit(ch)){
//                num = num * 10 + ch-'0';
//            }
//            if(!Character.isDigit(ch) || i == s.length()-1){
//                if(operation == '+'){
//                    stack.push(num);
//                }
//                if(operation == '-'){
//                    stack.push(-1*num);
//                }
//                if(operation == '*'){
//                    int previous = stack.pop();
//                    stack.push(previous*num);
//                }
//                if(operation == '/'){
//                    int previous = stack.pop();
//                    stack.push(previous/num);
//                }
//
//                num = 0;
//                operation = ch;
//            }
//        }
//
//        int result = 0;
//        for(int val:stack){
//            result = result + val;
//        }
//        return result;
//    }

    // Solution 2 - Without stack (O(N)/O(1))
//    public int calculate(String s) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//
//        s = s.replaceAll(" ","");
//        int num = 0;
//        int previous = 0;
//        int result = 0;
//        char operation = '+';
//
//        for(int i=0; i<s.length(); i++){
//            char ch = s.charAt(i);
//
//            if(Character.isDigit(ch)){
//                num = num * 10 + ch-'0';
//            }
//            if(!Character.isDigit(ch) || i == s.length()-1){
//                if(operation == '+'){
//                    result = result + previous;
//                    previous = num;
//                }
//                if(operation == '-'){
//                    result = result + previous;
//                    previous = -1 * num;
//                }
//                if(operation == '*'){
//                    previous = previous * num;
//                }
//                if(operation == '/'){
//                    previous = previous / num;
//                }
//
//                num = 0;
//                operation = ch;
//            }
//        }
//
//        return result + previous;
//    }

    // Solution 2.1 - further time improvement (removed the call for s.replaceALl(" ", "") which reduce time significantly)
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int num = 0;
        int previous = 0;
        int result = 0;
        char operation = '+';

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + ch-'0';
            }
            if(ch == '*' || ch=='+' || ch=='-' || ch == '/' || i == s.length()-1){
                if(operation == '+'){
                    result = result + previous;
                    previous = num;
                }
                if(operation == '-'){
                    result = result + previous;
                    previous = -1 * num;
                }
                if(operation == '*'){
                    previous = previous * num;
                }
                if(operation == '/'){
                    previous = previous / num;
                }

                num = 0;
                operation = ch;
            }
        }

        return result + previous;
    }
}
