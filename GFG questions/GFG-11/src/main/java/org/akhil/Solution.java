package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public String findOrder(String[] dict, int k) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }

        // Create the graph using given dictionary
        for(int i=0; i<dict.length-1; i++){
            String word1 = dict[i];
            String word2 = dict[i+1];

            int length = Math.min(word1.length(), word2.length());
            for(int j=0; j<length; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');      // a will be 0, b will be 1, c will be 2.
                    break;
                }
            }
        }

        // apply topological sort
        List<Integer> sorted = topoSort(adj, k);

        StringBuilder sb = new StringBuilder();
        for(int val:sorted){
            sb.append((char)(val+(int)'a'));
            sb.append(", ");
        }
        return sb.toString();
    }

    private List<Integer> topoSort(List<List<Integer>> adj, int k){
        // create and populate inDegree array

        int[] inDegree = new int[k];

        for(int i=0; i<adj.size(); i++){
            for(int val:adj.get(i)){
                inDegree[val]++;
            }
        }

        // populate queue with all elements with inDegree 0
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sorted = new ArrayList();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            sorted.add(temp);
            for(int adjValue:adj.get(temp)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.offer(adjValue);
                }
            }
        }

        return sorted;
    }
}
