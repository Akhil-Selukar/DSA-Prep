package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {

    // Time complexity - O(E+Q*V) where E -> number of edges, Q -> number of queries and V -> number of vertices
    // Space complexity - O(V+E)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // construct the weighted graph
        Map<String, Map<String, Double>> adj = new HashMap<>();

        for(int i=0; i<values.length; i++){                 // O(E) E-> number of edges
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double weight = values[i];

            constructMap(numerator, denominator, weight, adj);
        }

        // evaluate queries
        double[] answers = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){                // O(Q) Q-> number of queries
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            answers[i] = evaluate(start, end, adj, new HashSet<String>());
        }

        return answers;
    }

    private double evaluate(String start, String end, Map<String, Map<String, Double>> adj, HashSet<String> visited) {
        // case where start/numerator of query is not present
        if(!adj.keySet().contains(start)){              // O(1)
            return -1.0;
        }

        // case where end is the neighbour of start
        if(adj.get(start).containsKey(end)){        //O(1)
            return adj.get(start).get(end);
        }

        visited.add(start);
        // case where we have to traverse the graph to reach till end
        for(Map.Entry<String, Double> neighbour: adj.get(start).entrySet()){            // O(V) V-> vertices/nodes
            if(!visited.contains(neighbour.getKey())){
                double queryValue = neighbour.getValue() * evaluate(neighbour.getKey(), end, adj, visited);

                if(queryValue >= 0.0){
                    return queryValue;
                }
            }
        }

        // if end of query is not present in graph
        return -1.0;
    }

    private void constructMap(String numerator, String denominator, double weight, Map<String, Map<String, Double>> adj) {      // O(1)
        // given edge
        Map<String, Double> temp = adj.getOrDefault(numerator, new HashMap<>());
        temp.put(denominator, weight);
        adj.put(numerator, temp);

        // reverse edge
        Map<String, Double> tempRev = adj.getOrDefault(denominator, new HashMap<>());
        tempRev.put(numerator, 1/weight);
        adj.put(denominator, tempRev);
    }
}
