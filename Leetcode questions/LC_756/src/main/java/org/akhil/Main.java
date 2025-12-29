package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String bottom = "AAAA";
        List<String> allowed = Arrays.asList("AAB","AAC","BCD","BBE","DEF");

        Solution solution = new Solution();
        System.out.println(solution.pyramidTransition(bottom, allowed));
    }
}