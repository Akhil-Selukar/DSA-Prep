package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "10[a2[c]]";

        System.out.println(decodeString(str));
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        int repCount = 0;

        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                repCount = repCount*10 + Character.getNumericValue(ch);
            } else if(ch == '['){
                countStack.push(repCount);
                repCount = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else if(ch == ']'){
                int count = countStack.pop();
                StringBuilder tempBuilder = sb;
                sb = sbStack.pop();
                while(count>0){
                    sb.append(tempBuilder);
                    count--;
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}