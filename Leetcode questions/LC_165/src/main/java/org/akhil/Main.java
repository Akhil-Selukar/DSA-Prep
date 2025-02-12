package org.akhil;

public class Main {
    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0.0";

//        String version1 = "1.2";
//        String version2 = "1.10";

//        String version1 = "1.01";
//        String version2 = "1.001";

//        String version1 = "1.010";
//        String version2 = "1.001";

//        String version1 = "7.5.2.4";
//        String version2 = "7.5.3";

        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }
}