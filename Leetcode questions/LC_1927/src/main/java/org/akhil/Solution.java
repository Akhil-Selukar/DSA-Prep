package org.akhil;

public class Solution {

    // OBSERVATIONS -> Here important observation we need to make is if there is odd number of ? in given string then last turn will
    // always be of Alice and as they can choose any index i where there is a ? (not in sequence left to right).
    // As as both players are playing optimally so they will try to win. So Bob will always try to keep the left and
    // right sum equal (because it might happen that is the last ? and after he made the sum equal Alice does not have
    // any move to make the difference) and Bob wins.
    // Where as during Alice's turn she will always try to make the sum difference and if the sum differs by more than
    // 9 then she knows even if there is a move left for Bob he will not be able to make the sum equal as he can choose
    // number from 0 to 9. Hence alice will always try to maximise the difference between left and right sum.

    // CASE 1 -> Now in case of odd number of ?, last turn will always be of Alice so if Bob manages to make sum equal in his last
    // turn alice can add any number between 1 to 9 and win, and if Bob was not able to make the sum equal then she can
    // simply add a 0 in last ? and win. So if last turn is of Alice then she will always win.

    // Now for even number of ?
    // CASE 2 -> If we have equal number of ? on both sides then as both are playing optimally Alice will pick the side which has
    // higher known sum and keep on adding 9 to it, while bob will have to choose the other side and to cancel out the
    // difference he will also keep on adding 9. Which effectively mean that whatever is alice is adding bob is simply
    // nullifying it.
    // So in case of even ?. If we have equal number of question marks on both sides of middle point then eventually all
    // ? will get nullified and the winner will be decided based on the initial known sum.

    // CASE 3 -> Now third case is if even number of question marks are not distributed equally on both sides.
    // first thing we can do is we can cancel out the evenly distributed ? and only difference will be made by the
    // remaining one's. Let's consider we have left with 3 ? on right side.
    // now if we have left sum > right sum, then as ?'s are also on right side so Bob can match right sum to left sum
    // so if alice's optimal move is to waste ?'s so she will only add 0 to make sure Bob will not have many chances to
    // make sum equal and by adding any other number she will not help him. And bob's optimal move will be to add some
    // number x which will take him as close as possible to the left sum. (not always 9 because it might take right sum
    // past the left sum).
    // Another scenario is left sum < right sum and all ? are to the right. Now no matter what they do sum can not be
    // equal at any cost. But even if they had to play the optimal move will be alice will try to make difference even bigger
    // so now she is adding 9 while bob will have to add 0.

    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int leftQCount = 0;
        int rightQCount = 0;

        for(int i=0; i<n; i++){
            char ch = num.charAt(i);
            if(ch == '?'){
                if(i < n/2){
                    leftQCount++;
                } else {
                    rightQCount++;
                }
            } else {
                if(i < n/2){
                    leftSum = leftSum + ch-'0';
                } else {
                    rightSum = rightSum + ch-'0';
                }
            }
        }

        int totalQMarks = leftQCount + rightQCount;

        if(totalQMarks % 2 == 1){
            return true;        // alice wins
        }

        int left = (2 * leftSum) + (9 * leftQCount);
        int right = (2 * rightSum) + (9 * rightQCount);

        return !(left == right);        // both are equal bob wins, else alice wins
    }
}
