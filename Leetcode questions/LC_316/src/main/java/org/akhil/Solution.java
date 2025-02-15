package org.akhil;

import java.util.*;

public class Solution {

    // O(N)/O(N) -> Read the explanation once, why O(N)??
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            lastIndex.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack();
        Set<Character> visited = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            // if character is already considered then skip the iteration as no need to consider it again.
            if(visited.contains(s.charAt(i))){
                continue;
            }

            while(!stack.isEmpty()                     // stack is not empty that means we have some elements checked
                 && s.charAt(i) < stack.peek()      // current char is less that what we have in stack
                 && i < lastIndex.get(stack.peek())){    // the element in stack is again present somewhere in further string
                visited.remove(stack.peek());       // remove the element in stack from visited set
                stack.pop();                        // remove the element from stack as well, we will consider this element in it's next occurrence.
            }

            stack.push(s.charAt(i));
            visited.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for(char ch:stack){
            sb.append(ch);
        }

        return sb.toString();
    }
}
