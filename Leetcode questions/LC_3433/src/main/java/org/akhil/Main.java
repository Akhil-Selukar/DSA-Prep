package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = new ArrayList<>();
        events.add(Arrays.asList("MESSAGE", "10", "id1 id0"));
        events.add(Arrays.asList("OFFLINE","11","0"));
        events.add(Arrays.asList("MESSAGE","71","HERE"));

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countMentions(numberOfUsers, events)));
    }
}