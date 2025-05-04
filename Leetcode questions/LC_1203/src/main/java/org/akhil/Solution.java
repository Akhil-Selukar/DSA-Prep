package org.akhil;

import java.util.*;

public class Solution {

    // O(N+M+E)         as M can at max be N hence effective time complexity will be O(N+M)
    // O(N+M+E)         as M can at max be N hence effective space complexity will be O(N+M)
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step 1 - Assign groups to ungrouped elements.
        for(int i=0; i<n; i++){     // O(N)
            if(group[i] == -1){
                group[i] = m++;
            }
        }

        // step 2 - Create in-degree and adjacency lists for group and elements
        List<List<Integer>> items = new ArrayList<>();
        int[] inDegreeItems = new int[n];
        for(int i=0; i<n; i++){                     // O(N)
            items.add(new ArrayList<>());
        }

        List<List<Integer>> groups = new ArrayList<>();
        int[] inDegreeGroups = new int[m];      // here m will be updated based on step 1 hence it will cover all newly assigned groups as well.
        for(int i=0; i<m; i++){                 // O(M)
            groups.add(new ArrayList<>());
        }

        // effective TC - O(N + E)
        for(int i=0; i<n; i++){                             //O(N)
            for(int beforeItem:beforeItems.get(i)){         // O(E)
                // populate items graph and in-degree
                int sourceItem = beforeItem;
                int destinationItem = i;
                items.get(sourceItem).add(destinationItem);
                inDegreeItems[destinationItem]++;

                // populate group graph and in-degree
                int sourceGroup = group[beforeItem];
                int destinationGroup = group[destinationItem];
                if(sourceGroup != destinationGroup){
                    groups.get(sourceGroup).add(destinationGroup);
                    inDegreeGroups[destinationGroup]++;
                }
            }
        }

        // Step 3 - Topological sort for elements.
        List<Integer> itemsOrder = topoSort(items, inDegreeItems);
        // Step 4 - Topological sort for groups.
        List<Integer> groupsOrder = topoSort(groups, inDegreeGroups);

        // Step 5 - Arrange elements based on group
        if(itemsOrder.size() == 0 || groupsOrder.size() == 0){      // means no ordering possible
            return new int[]{};
        }

        Map<Integer, List<Integer>> groupWiseItems = new HashMap<>();
        for(int i:itemsOrder){
            List<Integer> temp = groupWiseItems.getOrDefault(group[i], new ArrayList<>());
            temp.add(i);
            groupWiseItems.put(group[i], temp);         // here we will get all elements in a group as value for that group key.
        }

        int[] result = new int[n];
        int index = 0;
        // O(M+N) in worst case
        for(int groupNo:groupsOrder){
            for(int item:groupWiseItems.get(groupNo)){
                result[index++] = item;
            }
        }

        return result;
    }


    // TC for topoSort - O(N+E)
    private List<Integer> topoSort(List<List<Integer>> graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int polled = queue.poll();
            result.add(polled);

            for(int adjValue:graph.get(polled)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.offer(adjValue);
                }
            }
        }

        return (result.size() == graph.size()) ? result : new ArrayList<>();
    }
}
