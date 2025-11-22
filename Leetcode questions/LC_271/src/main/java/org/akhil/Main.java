package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("we", "say", ":", "yes");

        Solution solution = new Solution();
        String encode = solution.encode(strs);

        System.out.println(solution.decode(encode));
    }
}