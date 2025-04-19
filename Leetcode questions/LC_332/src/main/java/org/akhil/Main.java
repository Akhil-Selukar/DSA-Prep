package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(List.of(new String[]{"JFK","SFO"})));
        tickets.add(new ArrayList<>(List.of(new String[]{"JFK","ATL"})));
        tickets.add(new ArrayList<>(List.of(new String[]{"SFO","ATL"})));
        tickets.add(new ArrayList<>(List.of(new String[]{"ATL","JFK"})));
        tickets.add(new ArrayList<>(List.of(new String[]{"ATL","SFO"})));

        Solution solution = new Solution();
        System.out.println(solution.findItinerary(tickets));
    }
}