package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};

        System.out.println(sqrtDecomposition(arr, 2, 7));   // 24
    }

    public static int sqrtDecomposition(int[] arr, int startIndex, int endIndex){
        int n = arr.length;
        int chunkSize = (int) Math.sqrt(n);

        int[] chunk = new int[chunkSize + 1];
        int chunkIndex = -1;

        // solve the individual chunk (filling the chunks are not necessary that was just for understanding)
        for(int i=0; i<n; i++){
            // initialize new block
            if(i % 3 == 0){
                chunkIndex++;
            }
            chunk[chunkIndex] += arr[i];    // this operation will depend on the query.
        }

        // query on actual required range
        return query(arr, chunk, startIndex, endIndex, chunkSize);
    }

    private static int query(int[] arr, int[] chunk, int startIndex, int endIndex, int chunkSize) {
        int answer = 0;

        // if in left side we have partial chunk
        while(startIndex%chunkSize != 0 && startIndex < endIndex && startIndex != 0){
            answer+=arr[startIndex];
            startIndex++;
        }

        // if entire chunk is needed
        while(startIndex + chunkSize <= endIndex){
            answer += chunk[startIndex/chunkSize];
            startIndex += chunkSize;
        }

        // if in right side we have partial chunk
        while(startIndex <= endIndex){
            answer += arr[startIndex];
            startIndex++;
        }

        return answer;
    }

    /*
    * **********EXTRA**********
    * In case we want to update any number in given array.
    * */
    // We need to update the chunk values as well along with actual array.
    public void update(int[] chunk, int[] arr, int index, int val, int sqrt) {
        int chunkIndex = index / sqrt;
        chunk[chunkIndex] += (val - arr[index]);
        arr[index] = val;
    }

}