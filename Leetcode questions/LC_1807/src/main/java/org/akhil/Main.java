package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();

        knowledge.add(List.of("name","bob"));
        knowledge.add(List.of("age","two"));

        Solution solution = new Solution();

        System.out.println(solution.evaluate(s, knowledge));
    }
}