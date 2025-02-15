package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String secret = "1807";
//        String guess = "7810";

//        String secret = "18071";
//        String guess = "88110";

        String secret = "1123";
        String guess = "0111";

        Solution solution = new Solution();
        System.out.println(solution.getHint(secret, guess));
    }
}