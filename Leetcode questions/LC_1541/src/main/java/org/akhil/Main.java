package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "))())(";

        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else {
                if(i<s.length()-1 && s.charAt(i+1)==')'){
                    i++;
                } else {
                    count++;
                }

                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        if(!stack.isEmpty()){
            count = count + (2*stack.size());
        }
        return count;
    }
}