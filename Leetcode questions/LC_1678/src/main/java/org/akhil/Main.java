package org.akhil;

public class Main {
    public static void main(String[] args) {
        String command = "G()()()()(al)";

        System.out.println(interpret(interpret(command)));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<command.length(); i++){
            if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                sb.append('o');
                i++;
            } else if(command.charAt(i) == '(' || command.charAt(i) == ')'){
            } else {
                sb.append(command.charAt(i));
            }
        }
        return sb.toString();
    }
}