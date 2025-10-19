package org.akhil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Do check the readme to understand why this is a graph problem and not recursion even though seems like recursion at first glance
// Similar question 752
public class Solution {
    // O(N^2)/O(N^2)
    public String findLexSmallestString(String s, int a, int b) {

        String result = s;
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);

        while (!queue.isEmpty()) {
            String polled = queue.poll();
            // As length of string can be of 100 chars hence below will not work
            // if(Long.parseLong(polled) < Long.parseLong(result)){
            //     result = polled;
            // }

            if (polled.compareTo(result) < 0) {
                result = polled;
            }

            char[] nums = polled.toCharArray();

            // perform addition operation and identify next possible states
            for (int i = 1; i < s.length(); i = i + 2) {
                nums[i] = (char) ((((nums[i] - '0') + a) % 10) + '0');
            }
            String addedStr = new String(nums);
            if (!visited.contains(addedStr)) {
                queue.offer(addedStr);
                visited.add(addedStr);
            }

            // perform rotation operation and identify the next possible state
            String rotatedStr = rotateRight(polled, b);
            if (!visited.contains(rotatedStr)) {
                queue.offer(rotatedStr);
                visited.add(rotatedStr);
            }
        }

        return result;
    }

    private String rotateRight(String s, int num) {
        StringBuilder sb = new StringBuilder(s);

        sb.reverse();
        reverse(sb, 0, num - 1);
        reverse(sb, num, sb.length() - 1);
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
