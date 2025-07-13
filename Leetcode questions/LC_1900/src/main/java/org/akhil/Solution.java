package org.akhil;

public class Solution {
    // Solution 1
//    private int n;
//    private int minRounds = Integer.MAX_VALUE;
//    private int maxRounds = Integer.MIN_VALUE;
//
//    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
//        this.n = n;
//        int mask = (1 << n) - 1;
//        firstPlayer--;
//        secondPlayer--;
//        allPossibleMatchups(mask, 0, n - 1, firstPlayer, secondPlayer, 1);
//        return new int[]{minRounds, maxRounds};
//    }
//
//    private void allPossibleMatchups(int mask, int left, int right, int p1, int p2, int rounds) {
//        if (left >= right) {
//            // We are done with current round. Goto next round.
//            allPossibleMatchups(mask, 0, n - 1, p1, p2, rounds + 1);
//        } else if ((mask & (1 << left)) == 0) {
//            // Skip the defeated left player
//            allPossibleMatchups(mask, left + 1, right, p1, p2, rounds);
//        } else if ((mask & (1 << right)) == 0) {
//            // Skip the defeated right player
//            allPossibleMatchups(mask, left, right - 1, p1, p2, rounds);
//        } else if (left == p1 && right == p2) {
//            minRounds = Math.min(minRounds, rounds);
//            maxRounds = Math.max(maxRounds, rounds);
//        } else {
//            if (left != p1 && left != p2) // Make right win
//                allPossibleMatchups(mask ^ (1 << left), left + 1, right - 1, p1, p2, rounds);
//
//            if (right != p1 && right != p2) // Make left win
//                allPossibleMatchups(mask ^ (1 << right), left + 1, right - 1, p1, p2, rounds);
//        }
//    }


    // ------------------------
    // Solution 2 - more simpler and intuitive
    // O(N^2)/O(1) only recursion stack space
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = firstPlayer; //P1
        int right = secondPlayer; //P2

        // Already to the opposite to each other.
        if (left == n - right + 1) {
            return new int[]{1, 1}; // Return a new int array initialized with values.
        }

        
        if (left > n - right + 1) {
            int temp = n - left + 1;
            left = n - right + 1;
            right = temp;
        }

        int minRound = n;
        int maxRound = 1;
        int nextRoundPlayersCount = (n + 1) / 2;

        if (right <= nextRoundPlayersCount) { //Case-1 both on the same side
            int countLeft = left - 1;
            int midCount = right - left - 1;

            for (int survivorsLeft = 0; survivorsLeft <= countLeft; survivorsLeft++) {
                for (int survivorsMid = 0; survivorsMid <= midCount; survivorsMid++) {
                    int pos1 = survivorsLeft + 1;
                    int pos2 = pos1 + survivorsMid + 1;
                    int[] tempResult = earliestAndLatest(nextRoundPlayersCount, pos1, pos2); // Recursive call returns an int array.

                    minRound = Math.min(minRound, tempResult[0] + 1); // Access array elements using [].
                    maxRound = Math.max(maxRound, tempResult[1] + 1); // Access array elements using [].
                }
            }
        } else { //case - 2 both on opposite end
            int fightsRight = n - right + 1;
            int countLeft = left - 1;
            int midCount = fightsRight - left - 1;
            int remainMidCount = right - fightsRight - 1;

            for (int survivorsLeft = 0; survivorsLeft <= countLeft; survivorsLeft++) {
                for (int survivorsMid = 0; survivorsMid <= midCount; survivorsMid++) {
                    int pos1 = survivorsLeft + 1;
                    int pos2 = pos1 + survivorsMid + (remainMidCount + 1) / 2 + 1;

                    int[] tempResult = earliestAndLatest(nextRoundPlayersCount, pos1, pos2); // Recursive call returns an int array.

                    minRound = Math.min(minRound, tempResult[0] + 1); // Access array elements using [].
                    maxRound = Math.max(maxRound, tempResult[1] + 1); // Access array elements using [].
                }
            }
        }
        return new int[]{minRound, maxRound}; // Return a new int array initialized with values.
    }
}
