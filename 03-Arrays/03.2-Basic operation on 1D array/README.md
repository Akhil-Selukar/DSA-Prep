## 03.2 Basic operations on 1D array.

In this section we will see the basic operations on 1D array in details and also analyze the time and space complexity 
for the operations.

### 1. Insertion
Data insertion means adding a new element in given array. Now there can be multiple scenarios while inserting an element 
in given array
<br>a. Given array is of size 5 and only first two indices are occupied. In this case we can simply access 3rd index by 
using index number 2 and assign new value to it like 'arr[2] = 5'. This is straight forward operation.<br>
b. Given array is of size 5 and all 5 places are occupied. In this case either we can send an error message or if we want 
we can double the size of the array and add the new element at last. This is a time-consuming operation as we have to create 
a completely new array.<br>
c. Given array is of size 5 and only first three indices are occupied, but here we want to insert element at 1st position 
(i.e. index 0) so first we will have to shift all the elements in given array to right by 1 place to make first place 
vacant and then add new element at index 0. This is also a time-consuming operation as we have to shift all the elements 
in given array

In general insertion in an array happens like below.

Main.java
```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        System.out.println(Arrays.toString(sda.arr));
    }
}
```

SingleDimensionalArray.java
```java
package org.akhil;

public class SingleDimensionalArray {
    int[] arr = null;

    public SingleDimensionalArray(int size) {
        this.arr = new int[size];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }
}
```

Here in above code we are creating an array of given size and initializing it to default value of `Integer.MIN_VALUE` (i.e. -2147483648)
We have already seen the time complexity of this code (i.e. for creation of an array) in last section, the time complexity is 
O(N). 

Now let's add another method for insertion of an element. This method will accept two parameters first one will be the 
index value where the element need to be added and second will be the actual value that need to be added. If the index 
is already occupied (i.e. has value other than Integer.MIN_VALUE) then it will show corresponding message otherwise will 
add the value at given index.
Have a look at below method from 'SingleDimensionalArray.java'

```java
public void insertElementAtIndex(int index, int value){
        try{
            if(arr[index] == Integer.MIN_VALUE){
                arr[index] = value;
                System.out.println("Value inserted successfully.");
            }else{
                System.out.println("Array index was already occupied.");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Given array index is incorrect.");
        }
    }
```

Above method is the one which is performing the operation of inserting value in an array. 
If we call this method from main method for different index and scenarios like below, we will get desired output.

```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        sda.insertElementAtIndex(0, 10);
        sda.insertElementAtIndex(1, 20);
        sda.insertElementAtIndex(3, 30);
        sda.insertElementAtIndex(1, 40);
        sda.insertElementAtIndex(7, 70);

        System.out.println(Arrays.toString(sda.arr));
    }
}
```

The output of above code is.

```markdown
Value inserted successfully.
Value inserted successfully.
Value inserted successfully.
Array index was already occupied.
Given array index is incorrect.
[10, 20, -2147483648, 30, -2147483648]
```

Now id we try to calculate the complexity for insertion of an element in given array we will get O(1) time complexity.
(Note that the complexity in case of adding element at the 0th index of pre-populated array and adding element to 
completely occupied array will be different.)

![Insertion of element in array(03-Arrays/03.2-Basic operation on 1D array/images/insertion of element in array.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.2-Basic%20operation%20on%201D%20array/images/insertion%20of%20element%20in%20array.png)