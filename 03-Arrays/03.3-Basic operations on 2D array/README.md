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