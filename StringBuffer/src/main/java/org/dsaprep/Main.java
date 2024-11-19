package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        System.out.println(sb.capacity());
        System.out.println(sb.length());

        sb.append("Hello world! ");
        sb.append("Isn't this a beautiful day?");

        System.out.println(sb.toString());
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        System.out.println(sb.charAt(4));
        System.out.println(sb.insert(6, "beautiful "));
        System.out.println(sb.deleteCharAt(2));
        System.out.println(sb.replace(15, 20, "human"));
        System.out.println(sb.reverse());
        System.out.println(sb.delete(0, sb.length()-2));

    }
}