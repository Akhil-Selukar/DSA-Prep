package org.akhil;

public class Solution {
    // Solution 1
//    public String reverseWords(String s) {
//        String[] arr = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=arr.length-1; i>=0; i--){
//            if(!arr[i].equals("")) {
//                sb.append(arr[i]);
//                sb.append(" ");
//            }
//        }
//
//        return sb.deleteCharAt(sb.length()-1).toString();
//    }

    // solution 1.1
//    public String reverseWords(String s) {
//        String[] arr = s.split("\\s+");     // this considers one or more consecutive spaces as single delimiter.
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=arr.length-1; i>=0; i--){
//            sb.append(arr[i]);
//            sb.append(" ");
//        }
//
//        return sb.toString().trim();
//    }

    // Solution 2 - (O(N)/O(N)) space is O(N) because of StringBuilder
    public String reverseWords(String s) {
        int end = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            if(end - i > 1){
                i++;
            }
            String lastWord = s.substring(i, end);

            if(!lastWord.equals(" ")){
                sb.append(lastWord);
                sb.append(" ");
            }
            end = i;
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
