package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // Simply perform what is asked replace the chars and find the max repeating char length

    // O(N*K)/O(N*K)
//    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//        char[] str = s.toCharArray();
//        int k = queryIndices.length;
//
//        int[] result = new int[k];
//        int resultIndex = 0;
//
//        for(int i=0; i<queryIndices.length; i++){
//            str[queryIndices[i]] = queryCharacters.charAt(i);
//
//            result[resultIndex] = getMaxRepeatingCharLen(str);
//            resultIndex++;
//        }
//
//        return result;
//    }
//
//    private int getMaxRepeatingCharLen(char[] str){
//        if(str.length == 0){
//            return 0;
//        }
//
//        int maxLen = 1;
//        int currLen = 1;
//        for(int i=1; i<str.length; i++){
//            if(str[i] == str[i-1]){
//                currLen++;
//            } else {
//                currLen = 1;
//            }
//            maxLen = Math.max(maxLen, currLen);
//        }
//        return maxLen;
//    }


    // --------------------------
    // Solution 2 - Segment tree approach
    private static class SegmentTree {

        private final int n;
        private final int[] prefix;
        private final int[] suffix;
        private final int[] best;
        private final char[] charStr;

        public SegmentTree(String s) {

            n = s.length();

            prefix = new int[n << 2];
            suffix = new int[n << 2];
            best = new int[n << 2];

            charStr = s.toCharArray();

            build(1, 0, n - 1);
        }

        private void build(int node, int l, int r) {

            // Leaf node
            if (l == r) {
                prefix[node] = 1;
                suffix[node] = 1;
                best[node] = 1;
                return;
            }

            int mid = (l + r) >>> 1;

            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);

            pushUp(node, l, r);
        }

        private void pushUp(int node, int l, int r) {

            int left = node << 1;
            int right = node << 1 | 1;

            int mid = (l + r) >>> 1;

            int lenL = mid - l + 1;
            int lenR = r - mid;

            prefix[node] = prefix[left];
            suffix[node] = suffix[right];

            best[node] = Math.max(best[left], best[right]);

            if (charStr[mid] == charStr[mid + 1]) {
                if (prefix[left] == lenL) {
                    prefix[node] = lenL + prefix[right];
                }
                if (suffix[right] == lenR) {
                    suffix[node] = lenR + suffix[left];
                }

                best[node] = Math.max(best[node], suffix[left] + prefix[right]);
            }
        }

        public void update(int i) {
            update(1, 0, n - 1, i);
        }

        private void update(int node, int l, int r, int i) {
            if (l == r) {
                return;
            }

            int mid = (l + r) >>> 1;

            if (i <= mid) {
                update(node << 1, l, mid, i);
            } else {
                update(node << 1 | 1, mid + 1, r, i);
            }

            pushUp(node, l, r);
        }

        public void updateChar(char c, int i) {
            charStr[i] = c;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryIndices.length;
        SegmentTree tree = new SegmentTree(s);
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int index = queryIndices[i];

            tree.updateChar(queryCharacters.charAt(i), index);
            tree.update(index);

            ans[i] = tree.best[1];
        }
        return ans;
    }
}
