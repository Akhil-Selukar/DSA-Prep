# Linear Search Algorithm

> [!Note]<br>
> **Use** - to search element in array<br>
> **Implementation** - iteration over array using simple for loop<br>
> **Time complexity** - O(N)<br>
> **Space complexity** - O(1)
> 

Linear Search, also known as Sequential Search, is a simple algorithm <ins>used to find the position of a **target value** within a **list or array**</ins>. 
It works by **sequentially checking each element** of the list until a match is found or the entire list has been searched.

---

## Use of the Algorithm

Linear search is a fundamental search algorithm and is useful in the following scenarios:

* **Small Datasets:** When the array or list to be searched is small, the overhead of more complex algorithms is not justified.
* **Unsorted Data:** It can be used on unsorted arrays or lists, unlike binary search which requires the data to be sorted.
* **Simple Implementation:** It's very easy to understand and implement, making it a good choice for beginners or when a quick and straightforward solution is needed.
* **Checking for Existence:** If you just need to know if an element is present or not, without needing optimal performance, linear search can suffice.

---

## Steps Involved in the Algorithm

1.  **Start from the beginning:** Begin iterating through the array from the first element (index 0).
2.  **Compare:** In each iteration, compare the current element with the **`target` value** you are looking for.
3.  **Match Found:** If the current element matches the `target`, the algorithm stops and returns the **index of the current element**.
4.  **Continue or End:** If there's no match, move to the next element in the array and repeat the comparison.
5.  **Target Not Found:** If the end of the array is reached and no match is found, the algorithm concludes that the `target` is not present in the array and typically returns a special value like **-1**.

---

## Example Walkthrough

Let's find `target = 40` in the array `[10, 20, 30, 40, 50]`.

1.  **Index 0 (10):** Is `10 == 40`? No.
2.  **Index 1 (20):** Is `20 == 40`? No.
3.  **Index 2 (30):** Is `30 == 40`? No.
4.  **Index 3 (40):** Is `40 == 40`? Yes! Return index 3.

---

## Time and Space Complexity

### Time Complexity [O(N)]

The time complexity of Linear Search is determined by the number of comparisons it performs.

* **Best Case: O(1)**
    * This occurs when the `target` element is found at the very **first position** (index 0) of the array. The algorithm performs only one comparison.
* **Worst Case: O(N)**
    * This occurs when the `target` element is at the very **last position** of the array, or when the `target` element is **not present** in the array at all. In this scenario, the algorithm has to iterate through all `N` elements, performing `N` comparisons.
* **Average Case: O(N)**
    * On average, if the element is present, it will be found somewhere in the middle of the array. Thus, it performs approximately `N/2` comparisons, which still simplifies to `O(N)` in Big O notation.

### Space Complexity [O(1)]

* **O(1)**
    * Linear search requires a **constant amount of extra space**, regardless of the size of the input array. It only uses a few variables (like an index counter and to store the target value) which don't grow with the input size.

---

## Code Snippet

```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        return i; // Target found, return its index
    }
}
return -1; // Target not found in the array
```