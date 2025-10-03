package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String start = "RXXLRXRXL";
//        String result = "XRLXXRRLX";

        String start = "LXXLXRLXXL";
        String result = "XLLXRXLXLX";

        Solution solution = new Solution();
        System.out.println(solution.canTransform(start, result));
    }
}