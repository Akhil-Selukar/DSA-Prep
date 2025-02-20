package org.akhil;

public class Main {
    public static void main(String[] args) {
        String queryIP = "172.16.254.1";
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String queryIP = "172.16.256.1";
//        String queryIP = "172.016.254.1";
//        String queryIP = "172.1@6.254.1";
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:73345";
//        String queryIP = "2001:0db8:85a3:0:8A2E:0370:7334";
//        String queryIP = "2001:0db8:85a3:0:fFfF:8A2E:0370:7334";
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";

        Solution solution = new Solution();
        System.out.println(solution.validIPAddress(queryIP));

    }
}