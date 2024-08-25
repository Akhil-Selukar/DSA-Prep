package org.akhil;

public class Main {
    public static void main(String[] args) {
        String address = "1.1.1.1";

        System.out.println(defangIPaddr1(address));
    }

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }

    // using stringBuilder takes less time as that of replaceAll method as replace all use regex which require pattern compilation and
    // execution of matcher.
    public static String defangIPaddr1(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<address.length(); i++){
            if(address.charAt(i) == '.'){
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}