package org.akhil;

public class Solution {

    // Solution 1 - bruteforce
    // O(N*maxPts)/O(N)         -> TLE
//    public double new21Game(int n, int k, int maxPts) {
//        // to store probability of getting each value from 0 to n.  (finally we will pick only the required ones from this)
//        double[] probability = new double[n+1];
//
//        probability[0] = 1;     // she always starts from 0, so she will always have 0 points.
//
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=maxPts; j++){        // loop of j (till maxPts) is because we have card for each of these value hence probability of having points from 1 to maxPts will be 1/maxPts.
//
//                if(i-j >=0 && i-j < k){
//                    //Probability of score j = 1/maxPts as explained above.
//                    //Remaining points = (i-j);
//                    //So,  probability[i] = Probability of j * Probability of remaining
//                    //i.e. probability[i] = 1/maxPts * probability[i-j]
//                    //Or, probability[i] = probability[i-j]/maxPts;
//
//                    probability[i] += probability[i - j] / maxPts;
//                }
//            }
//        }
//
//        // now we need probability of getting n or lower points
//        double result = 0.0;
//        for(int i=k; i<=n; i++){
//            result = result + probability[i];
//        }
//        return result;
//    }


    // Solution 2 - Use already calculated values
    // O(N)/O(N)
    public double new21Game(int n, int k, int maxPts) {
        // to store probability of getting each value from 0 to n.  (finally we will pick only the required ones from this)
        double[] probability = new double[n+1];

        probability[0] = 1;     // she always starts from 0, so she will always have 0 points.

        double currProbSum = k > 0 ? 1 : 0;

        for(int i=1; i<=n; i++){
            probability[i] = currProbSum / maxPts;

            if(i < k) {
                currProbSum = currProbSum + probability[i];
            }

            if(i - maxPts >= 0 && i-maxPts < k) {
                currProbSum = currProbSum - probability[i - maxPts];
            }
        }

        // now we need probability of getting n or lower points
        double result = 0.0;
        for(int i=k; i<=n; i++){
            result = result + probability[i];
        }
        return result;
    }
}
