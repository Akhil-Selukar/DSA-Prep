package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        List<String> l2 = new ArrayList<>();
        l2.add("c");
        List<String> l3 = new ArrayList<>();
        l3.add("a");
        l3.add("b");
        List<String> l4 = new ArrayList<>();
        l4.add("c");
        l4.add("b");
        List<String> l5 = new ArrayList<>();
        l5.add("a");
        l5.add("b");
        l5.add("x");
        List<String> l6 = new ArrayList<>();
        l6.add("a");
        l6.add("b");
        l6.add("x");
        l6.add("y");
        List<String> l7 = new ArrayList<>();
        l7.add("w");
        List<String> l8 = new ArrayList<>();
        l8.add("w");
        l8.add("y");

        paths.add(l1);
        paths.add(l2);
        paths.add(l3);
        paths.add(l4);
        paths.add(l5);
        paths.add(l6);
        paths.add(l7);
        paths.add(l8);

        Solution solution = new Solution();
        System.out.println(solution.deleteDuplicateFolder(paths));
    }
}