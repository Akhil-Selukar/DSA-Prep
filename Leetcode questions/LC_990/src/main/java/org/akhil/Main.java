package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String[] equations = {"b==a","a==b"};
//        String[] equations = {"a==b","b!=a"};
//        String[] equations = {"a==b","b==c", "c==a"};
//        String[] equations = {"a==b","b==c", "c!=a"};
        String[] equations = {"a==b","c!=a","b==c"};

        Solution solution = new Solution();
        System.out.println(solution.equationsPossible(equations));
    }
}