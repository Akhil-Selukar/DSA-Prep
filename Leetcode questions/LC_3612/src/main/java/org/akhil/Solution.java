package org.akhil;

class Solution {
    // O(2^N)/O(2^N)
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch:s.toCharArray()){
            switch(ch){
                case '*':{
                    if(sb.length() != 0){
                        sb.setLength(sb.length()-1);
                    }
                    break;
                }
                case '#':{
                    sb.append(sb.toString());
                    break;
                }
                case '%':{
                    String temp = sb.reverse().toString();
                    sb.setLength(0);
                    sb.append(temp);
                    break;
                }
                default:{
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
