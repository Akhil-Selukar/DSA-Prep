# Binary Search Algorithm

Binary Search is an <ins>efficient algorithm for finding a **target value** within a **sorted array or list**</ins>. 
Unlike linear search, which checks every element, binary search repeatedly divides the search interval in half.

> [!NOTE] <br>
> **Use** - to search element in array<br>
> **Prerequisites** - given array or list must be sorted.<br>
> **Implementation** - iteration over array using simple for loop<br>
> **Time complexity** - O(log N)<br>
> **Space complexity** - O(1)

---

## Use of the Algorithm

Binary search is a highly efficient search algorithm, particularly useful in these situations:

* **Large Sorted Datasets:** It is exceptionally fast for searching through large collections of data that are already sorted (e.g., searching for a word in a dictionary, an item in a sorted database, or a number in a sorted array).
* **Faster than Linear Search:** For sorted data, binary search offers significantly better performance than linear search.
* **Finding "Nearest" Elements:** Variations of binary search can be used to find the element closest to a target, or the first/last occurrence of a duplicate.
* **Implementing Other Algorithms:** It forms the basis for many other algorithms, such as finding the square root of a number, or solving problems on a monotonic function.

**Crucial Requirement:** The data **must be sorted** (either in ascending or descending order) for binary search to work correctly.

---

## Steps Involved in the Algorithm

1.  **Define Search Space:** Initialize two pointers, `low` (or `left`) to the first index of the array (0) and `high` (or `right`) to the last index of the array (`length - 1`).
2.  **Calculate Midpoint:** While `low` is less than or equal to `high`, calculate the middle index: `mid = low + (high - low) / 2`.
    * Using `low + (high - low) / 2` avoids potential integer overflow that could occur with `(low + high) / 2` if `low` and `high` are very large.
3.  **Compare:**
    * If the element at `mid` index (`arr[mid]`) is equal to the `target`, the target is found. Return `mid`.
    * If `arr[mid]` is **less than** the `target`, it means the target, if present, must be in the **right half** of the current search space. Update `low = mid + 1`.
    * If `arr[mid]` is **greater than** the `target`, it means the target, if present, must be in the **left half** of the current search space. Update `high = mid - 1`.
4.  **Repeat or Conclude:** Repeat steps 2-3 until the `target` is found or the `low` pointer crosses the `high` pointer (`low > high`).
5.  **Target Not Found:** If `low` becomes greater than `high`, it means the target is not present in the array. Return -1.

---

## Example Walkthrough

Let's find `target = 40` in the sorted array `[10, 20, 30, 40, 50, 60, 70]`.

* **Initial:** `low = 0`, `high = 6` (length-1)
* **Iteration 1:**
    * `mid = 0 + (6 - 0) / 2 = 3`
    * `arr[3]` is `40`.
    * Is `arr[mid] == target`? Yes, `40 == 40`.
    * **Target found at index 3.** Return 3.

Let's find `target = 35` in the sorted array `[10, 20, 30, 40, 50, 60, 70]`.

* **Initial:** `low = 0`, `high = 6`
* **Iteration 1:**
    * `mid = 3` (`arr[3] = 40`)
    * Is `arr[mid] == target`? No.
    * Is `arr[mid] < target`? No, `40` is not less than `35`.
    * So, `arr[mid] > target`. Update `high = mid - 1 = 3 - 1 = 2`.
    * Current search space: `[10, 20, 30]` (`low = 0`, `high = 2`)
* **Iteration 2:**
    * `mid = 0 + (2 - 0) / 2 = 1`
    * `arr[1]` is `20`.
    * Is `arr[mid] == target`? No.
    * Is `arr[mid] < target`? Yes, `20 < 35`. Update `low = mid + 1 = 1 + 1 = 2`.
    * Current search space: `[30]` (`low = 2`, `high = 2`)
* **Iteration 3:**
    * `mid = 2 + (2 - 2) / 2 = 2`
    * `arr[2]` is `30`.
    * Is `arr[mid] == target`? No.
    * Is `arr[mid] < target`? Yes, `30 < 35`. Update `low = mid + 1 = 2 + 1 = 3`.
    * Current search space: Empty (`low = 3`, `high = 2`). `low` is now greater than `high`.
* **Loop Ends.** Target not found. Return -1.

---

## Time and Space Complexity

### Time Complexity

The time complexity of Binary Search is logarithmic, which is highly efficient for large datasets.

* **Best Case: O(1)**
    * This occurs when the `target` element is found at the exact middle of the array on the very first comparison.
* **Worst Case: O(log N)**
    * This occurs when the `target` element is at one of the ends of the array, or when the `target` element is not present at all. In each step, the search space is halved. For an array of size `N`, it takes approximately `log₂N` comparisons to narrow down the search to a single element or determine its absence.
* **Average Case: O(log N)**
    * On average, the number of comparisons will also be proportional to `log₂N`.

### Space Complexity

* **Iterative Approach: O(1)**
    * The iterative implementation of binary search uses a **constant amount of extra space**, regardless of the input array size. It only requires a few variables to store pointers (`low`, `high`, `mid`).
* **Recursive Approach: O(log N)**
    * A recursive implementation would use space on the call stack proportional to the depth of the recursion, which is `log N`.

---

## Code Snippet

```java
 public int search(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
        return -1; // Handle empty or null array
    }
        
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // Calculate middle index

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            left = mid + 1; // Target is in the right half, discard left half
        } else { // arr[mid] > target
            right = mid - 1; // Target is in the left half, discard right half
        }
    }
    return -1; // Target not found
}
```