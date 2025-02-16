package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    public List<String> fizzBuzz(int n) {
//        List<String> answer = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            StringBuilder sb = new StringBuilder();
//
//            if((i+1)%3 == 0){
//                sb.append("Fizz");
//            }
//            if((i+1)%5 == 0){
//                sb.append("Buzz");
//            }
//
//            if(sb.isEmpty()){
//                sb.append((i+1));
//            }
//
//            answer.add(sb.toString());
//        }
//
//        return answer;
//    }

    // Solution 2 - without using StringBuilder (O(N)/O(N))
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            boolean divisibleByThree = ((i+1)%3 == 0);
            boolean divisibleByFive = ((i+1)%5 == 0);

            if(divisibleByThree && divisibleByFive){
                answer.add("FizzBuzz");
            } else if(divisibleByThree){
                answer.add("Fizz");
            } else if(divisibleByFive){
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i+1));
            }
        }

        return answer;
    }
}
