package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String preorder = "9,#,92,#,#";
        String preorder = "#,7,6,9,#,#,#";
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization(preorder));
    }
}