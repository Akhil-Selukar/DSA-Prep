package org.akhil;

import java.util.*;

public class Solution {
    private class Pair{
        private int stops;
        private int city;
        private int cost;

        public Pair(int stops, int city, int cost){
            this.stops = stops;
            this.city = city;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int noOfCities, int[][] flights, int source, int destination, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<noOfCities; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(0, flights[i][1], flights[i][2]));
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, source, 0));

        int[] cost = new int[noOfCities];
        Arrays.fill(cost, (int)1e9);
        cost[source] = 0;

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int stops = temp.stops;
            int currentCity = temp.city;
            int totalCost = temp.cost;

            if(stops > k){      // if number of stops are greater than allowed stops then no need to check further for that route.
                continue;
            }

            for(Pair possibleDestinations:adj.get(currentCity)){
                int newDestination = possibleDestinations.city;
                int newCost = totalCost + possibleDestinations.cost;
                int newNoOfStops = stops+1;

                // only add to the queue if new cost to reach this city is less than the other route and number of stops are still within the limit.
                // otherwise this route is of no use.
                if(newCost < cost[newDestination] && newNoOfStops <= k+1){      // k+1 here because the code will consider destination as a stop as well but in question we are not considering it as a stop. So either add 1 here or modify the stop count after checking this condition inside.
                    queue.offer(new Pair(newNoOfStops, newDestination, newCost));
                    cost[newDestination] = newCost;
                }
            }
        }

        if(cost[destination] == (int)1e9){
            return -1;
        } else {
            return cost[destination];
        }
    }
}
