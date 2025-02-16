package org.akhil;

import java.util.Stack;

public class Solution {

    // O(N)/O(D) where D is depth of directory structure.
    public int lengthLongestPath(String input) {
        int maxLength = 0;
        String[] parts = input.split("\n");
        Stack<Integer> stack = new Stack();

        for(String part:parts){
            int depth = 0;
            depth = part.lastIndexOf('\t')+1;

            // more readable way to calculate depth is
            /*
            while(part.charAt(depth) == '\t'){
                depth++;
            }
            */
            while(stack.size() > depth){
                stack.pop();
            }

            String name = part.substring(depth);
            int length = (stack.isEmpty() ? 0 : stack.peek()) + (stack.isEmpty() ? 0 : 1) + name.length();      // length till that level/depth from stack + 1  for "\" + length of fileName.

            if(name.contains(".")){
                maxLength = Math.max(length, maxLength);
            } else {
                stack.push(length);
            }
        }

        return maxLength;
    }
}
