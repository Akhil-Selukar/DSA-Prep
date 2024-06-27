## 03.3 Basic operations on 2D array.

2D arrays are nothing but more than one 1D array placed one below another to form a matrix like structure.
2D array has two type of index i.e. a row index (i) and a column index (j).

In this section we will see some basic operations related to 2D array and their complexities.

### 1. Creation of 2D array

In one of the previous section we have already seen how [2D arrays are represented in memory](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/03-Arrays#types-of-array:~:text=Now%20how%20about%202D%2Darrays).
Now let's have a look at the code to create an actual 2D array. Creation of 2D array also involve same set of steps as that 
of 1D array. i.e. Declaration, instantiation and initialization. (Also just like 1D array all these steps can be clubbed 
together). Have a look at below code. 


```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Declaration
        int[][] matrix;
        // Instantiation
        matrix = new int[2][2];

        // Initialization
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        System.out.println(Arrays.deepToString(matrix));
    }
}
```

Here at first line i.e. `int[][] matrix;` we have declared an array of name 'matrix'. When this line executes it creates 
a reference variable with name matrix. In next step at line `matrix = new int[2][2];` we initialize a 2D array of 2 rows and 
2 columns, when this line executes a memory location is assigned for the array (i.e. 4 consecutive memory locations) and 
address of first memory location is stored in the reference variable. Now at initialization part we have accessed each 
and every array element and assigned value to it. 

By using `deepToString()` method of 'Arrays' class we can convert any 2D array into string, so by using this we have converted 
the array into string and printed as output. The output of above code will be.

```markdown
[[1, 2], [3, 4]]
```

Here if we check the complexity of this operation. The declaration and instantiation will take O(1) time complexity while
initialization will be O(MN) where M is number of rows and N is number of columns. So overall complexity for creation of 
2D array will be O(MN). 

![Creation of 2D array](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.3-Basic%20operations%20on%202D%20array/images/Creation%20of%202D%20array.png)

As mentioned in the start all the three steps can be clubbed into one single step like below. In this case the complexity
will be O(1), as the code will not have to perform multiple operations.

```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] newMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(newMatrix));
    }
}
```

Here the output will be an array of 3 rows and 3 columns like below.

```markdown
[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```

### 2. Insertion in a 2D array
Here inserting an element means not initializing the array, here inserting means adding a value at given index of 2D array.
As we know that index of 2D array always has 2 values i.e. row index and column index. Here the task for us is we will be 
having a 2D array (as per general industry practice all the elements in the array will have value of minimum integer value.)
We are given with index of row and column and a value to insert at given place (row and column). Let's have a look at code 
for this task.

`TwoDimensionArray.java`
```java
package org.akhil;

public class TwoDimensionArray {
    int[][] arr;
    public TwoDimensionArray(int numberOfRows, int numberOfColumns) {
        arr = new int[numberOfRows][numberOfColumns];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    // Insert value at given index.
    public void insertValueAtGivenIndex(int row, int col, int value){
        try{
            if(arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("Value inserted successfully..!!");
            } else {
                System.out.println("The cell at given index is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array index are invalid");
        }
    }
}
```

`main.java`
```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionalArray = new TwoDimensionArray(3, 3);

        twoDimensionalArray.insertValueAtGivenIndex(0,0,15);

        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));
    }
}
```

Here in class `TwoDimensionArray.java` we are using constructor to initialize an array of given number of rows and columns.
And we are assigning initial value as Integer.MIN_VALUE to each cell.

The method `insertValueAtGivenIndex(int row, int col, int value)` is the one we are interested in. Here we are accepting 
row index, column index and the value to insert at that index, then we are checking if the cell at given index is occupied 
or not and if not then we are inserting the given value at that cell.

the output of above code is.

```markdown
Value inserted successfully..!!
[[15, -2147483648, -2147483648], [-2147483648, -2147483648, -2147483648], [-2147483648, -2147483648, -2147483648]]
```

Here if we check the complexity of this method (insertion operation in 2D array) it will be like below.

![Insertion in 2D array(03-Arrays/03.3-Basic operations on 2D array/images/Insertion in 2D array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.3-Basic%20operations%20on%202D%20array/images/Insertion%20in%202D%20array.png)

From above image we can clearly see that the insertion of an element at given index in 2D array has time complexity of 
O(1), also as we are not using any extra variable for this operation hence the space complexity is also O(1).


### Accessing element of a 2D array.
Here the task is from an array we want to access and print the element at given row and column. Here we will be using 
the code which we have already written in above part and add below method TwoDimensionArray.java to access element based 
on given row and column.

```java
    // Access element at given row and column
    public void accessElementAtGivenIndex(int row, int col){
        System.out.println("Accessing element at "+row+"th row and "+col+"th column");
        try{
            System.out.println("Element at "+row+"th row and "+col+"th column is "+arr[row][col]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array indices are invalid");
        }
    }
```

Now before calling this method from main class let's add some mre values in the array.

`main.java`
```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3,3);

        twoDimensionArray.insertValueAtGivenIndex(0,0,1);
        twoDimensionArray.insertValueAtGivenIndex(0,1,2);
        twoDimensionArray.insertValueAtGivenIndex(1,1,5);

        System.out.println(Arrays.deepToString(twoDimensionArray.arr));

        twoDimensionArray.accessElementAtGivenIndex(1,1);
    }
}
```

Here first we initialized an array of 3 rows and 3 columns. Then we assigned values 1, 2 and 5 at specific indices. After 
that we used the method `accessElementAtGivenIndex()` to access element at 1st row and 1st column. (i.e. element 5).

Below will be the output of above code.

```markdown
Value inserted successfully..!!
Value inserted successfully..!!
Value inserted successfully..!!
[[1, 2, -2147483648], [-2147483648, 5, -2147483648], [-2147483648, -2147483648, -2147483648]]
Accessing element at 1th row and 1th column
Element at 1th row and 1th column is 5
```

Now if we check the complexity for method to access element at given indices of a 2D array, it will be like below.

![Accessing element of a 2D array(03-Arrays/03.3-Basic operations on 2D array/images/Accessing element of 2D array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.3-Basic%20operations%20on%202D%20array/images/Accessing%20element%20of%202D%20array.png)

From above image we can clearly see that the time complexity of accessing element of a 2D array is O(1) also as no additional
memory space is required hence the space complexity is also O(1).

### 3. Traversing 2D array.

Traversing an array means visiting all elements of the array one by one. This is done by using index. In case of 2D
arrays, as we have already seen that the array is stored in memory as an array of multiple single dimensional arrays. So 
to traverse a 2D array we will be traversing multiple one dimensional arrays one by one. So we will need 2 for loops, one 
to keep track of the array out of multiple one dimensional arrays and another to loop over all elements of that array.
Have a look at below code.

`TwoDimensionArray.java`
```java
package org.akhil;

public class TwoDimensionArray {
    int[][] arr;

    public TwoDimensionArray(int row, int col) {
        arr = new int[row][col];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = (i+1)*(j+1);
            }
        }
    }

    // Traversal of 2D array
    public void traverse2DArray(){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
}
```

`main.java`
```java
package org.akhil;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3,3);

        twoDimensionArray.traverse2DArray();
    }
}
```

Here as well we are using same code as that of the previous one, just small change is, in constructor we have added logic 
to initialize the array with some actual values instead of just Integer.MIN_VALUE. Then by using method `traverse2DArray()`
we are iterating over the 2D array (By iterating over each row and inside that each element.) If we check the output of 
above code we will see below matrix.

```markdown
1 2 3 
2 4 6 
3 6 9 
```

If we calculate the complexity of method for traversing the 2D array, it will be like below.

![Iteration over 2D array(03-Arrays/03.3-Basic operations on 2D array/images/Iteration over 2D array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.3-Basic%20operations%20on%202D%20array/images/Iteration%20over%202D%20array.png)

From above image we can see that first loop will be executed for M times, where M is the number of rows.
For every iteration of row, the inner loop (for col) will be executed for N times, where N is the number of columns in each row.
As for each iteration of M, inner loop will be iterating N times. Hence the time complexity for this overall operation will be 
O(MN). Now as we are not using any extra memory location for this operation so the space complexity will be O(1).

### 4. Searching element in 2D array.

Here the problem statement is, you are given with a value, and you have to search that value in a 2D array. If the value 
is present then print the indices of it and if value is not present then print the message "given value is not present in 
array". For this there are many algorithms available, but as of now the approach we will use is to traverse the 2D array 
and compare the value at each index with the given value (linear search). This is very similar to that of above (traversing 
2D array). We just replace traverse2DArray() method with below `searchValueIn2DArray(int value)` method.

```java
public void searchValueIn2DArray(int value){
    for(int row=0; row<arr.length; row++){
        for(int col=0; col<arr.length; col++){
            if(arr[row][col] == value){
                System.out.println(value + " is present at row number "+row+" and column number "+col);
                return;
            }
        }
    }
    System.out.println("Given value is not present in the array..!!");
}
```

Here the method is exactly same as that of traversing, just instead of printing all the elements we are comparing the value 
to given value. Here as well the time and space complexity will be same i.e. O(MN) and O(1) respectively.

### Deleting(Updating) value at given index of 2D array.

Deleting value at specific index from an array is nothing but setting it to the default value (in our case Integer.MIN_VALUE).
This we can do by simply accessing the cell at given row and column index and setting it's value to default value. Have a 
look at below code.

`TwoDimensionArray.java`
```java
package org.akhil;

public class TwoDimensionArray {
    int[][] arr;

    public TwoDimensionArray(int row, int col) {
        arr = new int[row][col];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = (i+1)*(j+1);
            }
        }
    }

    // Delete value at given index
    public void deleteValueAtGivenIndex(int rowIndex, int columnIndex){
        try{
            arr[rowIndex][columnIndex] = Integer.MIN_VALUE;
            System.out.println("Value at row "+rowIndex+" and column "+columnIndex+" is deleted successfully..!!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array index are invalid..!!");
        }
    }
}
```

`main.java`
```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3,3);

        System.out.println("Array before deletion :");
        System.out.println(Arrays.deepToString(twoDimensionArray.arr));

        twoDimensionArray.deleteValueAtGivenIndex(1,1);

        System.out.println("Array after deletion :");
        System.out.println(Arrays.deepToString(twoDimensionArray.arr));
    }
}
```

Here in method `deleteValueAtGivenIndex(int rowIndex, int columnIndex)` we are simply accessing array element based on given
indices and updating it's value with default value (i.e. Integer.MIN_VALUE). The output of above code will be.

```markdown
Array before deletion :
[[1, 2, 3], [2, 4, 6], [3, 6, 9]]
Value at row 1 and column 1 is deleted successfully..!!
Array after deletion :
[[1, 2, 3], [2, -2147483648, 6], [3, 6, 9]]
```

Here from above output we can clearly see that the value at index 1,1 is deleted (set to default value).

If we calculate the complexity of this code, as it is a straight forward accessing an element of 2D array. The complexity 
will be same as that of accessing element in 2D array which is O(1). Also, as no additional memory location is required
the space complexity will also be O(1).


So to summarize time and space complexities of operations on 2D array are as below.

![Complexities of 2D array(03-Arrays/03.3-Basic operations on 2D array/images/Complexities of 2D array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.3-Basic%20operations%20on%202D%20array/images/Complexities%20of%202D%20array.png)