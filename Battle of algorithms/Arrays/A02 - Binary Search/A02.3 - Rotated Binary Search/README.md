```java
public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Handle duplicates: if start, mid, and end are all the same,
            // we can't determine which side is sorted, so shrink the window.
            // This is crucial for arrays like [1, 1, 1, 1, 0, 1, 1]
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue; // Skip to next iteration with smaller window
            }

            // Determine if the start half is sorted
            if (arr[start] <= arr[mid]) {
                // start half is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    // Target is in the start sorted half
                    end = mid - 1;
                } else {
                    // Target is in the end unsorted half (or beyond start half range)
                    start = mid + 1;
                }
            } else {
                // end half must be sorted (arr[mid] < arr[end])
                if (target > arr[mid] && target <= arr[end]) {
                    // Target is in the end sorted half
                    start = mid + 1;
                } else {
                    // Target is in the start unsorted half (or beyond end half range)
                    end = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
```