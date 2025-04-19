package org.akhil;

import java.util.*;

public class Solution {

    // O(T + V*Dlog(D))/O(V+T)  where V is number of vertices i.e. airports and D is total destinations and T is total number of tickets.
    // space complexity is due to adj.
    public List<String> findItinerary(List<List<String>> tickets) {

        // Create adjacency list
        Map<String ,List<String>> adj = new HashMap<>();

        for(List<String> trip:tickets){         // O(T) where T is number of tickets
            String source = trip.get(0);
            String desti = trip.get(1);

            List<String> temp = adj.getOrDefault(source, new ArrayList<>());
            temp.add(desti);
            adj.put(source, temp);

            // all above can be done in one line as below
//            adj.computeIfAbsent(source, k->new ArrayList<>()).add(desti);
        }

        // sort the destinations required to maintain lexicographical order or travel.
        for(List<String> destinations:adj.values()){        // O(V) where V is total vertices i.e. total airports
            Collections.sort(destinations);                 // O(Dlog(D)) where D is number of destinations
        }
                                                            // Therefor time complexity for above sorting loop is O(V*Dlog(D))

        // start fro "JFK"
        List<String> travel = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");          // starting from JFK hence current station at start will be JFK.

        while(!stack.isEmpty()){                    // this loop will execute once per edge and each edge is represented by a ticket hence this loop will execute number of Tickets time O(T)
            String currentLocation = stack.peek();

            if(adj.containsKey(currentLocation) && !adj.get(currentLocation).isEmpty()){
                stack.push(adj.get(currentLocation).remove(0));
            } else {
                travel.add(stack.pop());
            }
        }

        // reverse takes O(T)
        Collections.reverse(travel);    // itinerary will be in reverse order here.
        return travel;
    }
}
