package org.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    // O(N log(N))/O(N)
    /*
    Time Complexity:
        1. Building the frequency map: The initial loop iterates through the string s once. This takes O(n) time, where n is the length of s.
        2. Adding to the priority queue: Adding all entries from the map to the priority queue takes O(m log m) time, where m is the number of unique characters in s. In the worst case, m could be equal to n (if all characters are unique).
        3. Building the result string: The while loop iterates through the priority queue. In the worst case, it will iterate m times. Inside the loop, the inner for loop iterates entry.getValue() times. The total number of times the inner loop runs across all iterations of the outer loop is equal to n (the length of the string).
        4. Overall Time Complexity: The dominant factors are the initial loop (O(n)) and adding to the priority queue (O(m log m)). Since m can be at most n, the overall time complexity can be expressed as O(n + n log n), which simplifies to O(n log n).

    Space Complexity:
        1. map: The map stores the frequencies of characters. In the worst case, it could store all unique characters in s, so its space complexity is O(m), which could be O(n) in the worst case.
        2. queue: The priority queue stores the entries from the map. Its size is also O(m), which could be O(n) in the worst case.
        3. sb: The StringBuilder stores the sorted string. Its space complexity is O(n), as the length of the sorted string is equal to the length of the input string.
        4. Overall Space Complexity: The space used by the map, the queue, and the StringBuilder are all potentially O(n). Therefore, the overall space complexity is O(n).
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
