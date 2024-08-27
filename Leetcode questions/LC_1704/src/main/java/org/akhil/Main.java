package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "book";

        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':{
                    if(i < s.length()/2){
                        count++;
                    } else {
                        count--;
                    }
                }
            }
        }
        return count == 0;
    }
}