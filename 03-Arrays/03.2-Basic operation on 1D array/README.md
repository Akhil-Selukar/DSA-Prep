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

In general insertion in an array happens like below. ([Code link](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/03-Arrays/03.2-Basic%20operation%20on%201D%20array/Insertion%20of%20element%20in%201D%20array))

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

### 2. Accessing element - 
We can access element of an array by using the index value. We have already seen how array elements are stored and fetched 
based on index value from memory in [last section](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/03-Arrays/03.1-Creation%20of%20an%20array).

Now to access element based on index you can refer below code ([code link]())
Here we are using the code written in insertion example. Below is the addition of code in main class for accessing element 
based on index.

Main.java
```java
package org.akhil;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        sda.insertElementAtIndex(0, 10);
        sda.insertElementAtIndex(1, 20);
        sda.insertElementAtIndex(2, 30);
        sda.insertElementAtIndex(3, 40);
        sda.insertElementAtIndex(4, 50);

        // Accessing elements
        int firstElement = sda.arr[0];
        System.out.println("First element in the array is "+firstElement);
        int fourthElement = sda.arr[3];
        System.out.println("Fourth element in the array is "+fourthElement);

    }
}
```

Here we have first created an array of 5 elements, then added value for each and every index.
Then by using index i.e. 0 and 3 we are fetching the value at 1st and 4th place and printing it.
As mentioned earlier in section [creation of an array](https://github.com/Akhil-Selukar/DSA-Prep/tree/master/03-Arrays/03.1-Creation%20of%20an%20array)
given index value will be added in the first memory location, and then the value at resultant memory location will be fetched.

The time and space both complexity will be O(1) for this operation as we are not using any additional memory and irrespective
of the index value (0 or N) we will execute the code only once for fetching value.

The output of above code will be.
```markdown
Value inserted successfully.
Value inserted successfully.
Value inserted successfully.
Value inserted successfully.
Value inserted successfully.
First element in the array is 10
Fourth element in the array is 40
```

### 3. Traversal of array elements - 
Traversing an array means looping through all the elements of an array. So no doubt we will have to use a loop for this 
operation. Below code shows how we can traverse through an array. 

```java
package org.akhil;

public class Main {
    public static void main(String[] args) {
        int arr[] = {4,6,7,8,2};

        for(int i=0; i< arr.length; i++){
            System.out.println("Element at index "+i+" is "+arr[i]);
        }
    }
}
```

Here we have created an array with 5 elements and using a for loop we are traversing through the array to print all the 
elements.

If we analyse the code for time and space complexity, then to traverse an array we need to loop over it, so the number of 
iterations will directly be affected by size of given array. So time complexity will be O(N) while to traverse over an 
array we don't need any additional memory hence the space complexity will be O(1).


### 4. Searching given element in an array
Here the task is to search given element is present in an array or not, if the element is present then we have to display 
message 'Element found at index {index}' and if the element is not present then it should display the message 'Array 
element does not exist'. To perform this task there can be many ways like sort the array first and then use divide and 
conquer, or any other algorithm. But for now as we have not seen any of the algorithms in details, so we will go for vary 
basic approach which is to loop over an array and match each element against given element. If the match is found then 
print the appropriate message and terminate the loop else print failure message. Have a look at below code.

SingleDimensionalArray.java
```java
package org.akhil;

public class SingleDimensionalArray {
    
    public void searchElementInArray(int elementToSearch, int[] arr){
        for(int i=0; i< arr.length; i++){
            if(arr[i] == elementToSearch){
                System.out.println("Element found at index "+i);
                return;
            }
        }
        System.out.println("Element not found in given array");
    }
}
```

Here we are looping over the given array and matching each array element to the given element to search. When the match is 
found we are printing appropriate message and if no match is found after complete traversal of the array we are printing 
failure message.

To call this method from Main.java, we have written below code.

Main.java
```java
package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8,9,4,6,7,3,1,2,5};

        SingleDimensionalArray sda = new SingleDimensionalArray();

        sda.searchElementInArray(3, arr);
    }
}
```

Here we are trying to find element 3 in given array.
The output of above code will be.

```markdown
Element found at index 5
```

Now to calculate the time and space complexity for this code, we know that we are looping over the array till we get the 
matching element. In worst case scenario we might not get the matching element, so in that case we will be looping over 
all the elements. We already know that the time complexity for such code is O(N) as number of iterations will increase as
size of array increases. And for this searching we do not need any additional memory hence the space complexity will be 
O(1).

### 5. Deleting an element in given array.
Now technically we can't make any cell/index of an array as empty. Even when we create an array, before assigning values
to it, the default values are 0 (in case of integer array). But normally in industry it is a common practice to use 
Integer.MIN_VALUE as default value as we might consider 0 as actual element in some cases.
So basically deleting any element from array is nothing but setting the element to Integer.MIN_VALUE. Below is the code 
for this operation.

(Note: here we are considering that we have index of element to delete, there can be some scenario where you will have the 
value and not the index. So in that case you will have to loop over array to find the index and delete it. The complexity 
will be different in that case.)

SingleDimensionalArray.java
```java
package org.akhil;

public class SingleDimensionalArray {
    int[] arr = null;

    public SingleDimensionalArray(int sizeOfArray) {
        this.arr = new int[sizeOfArray];

        for(int i=0;i<arr.length; i++){
            this.arr[i] = (i+1)*10;
        }
    }

    // Delete element at specific index.
    public void deleteElementOfAnArray(int index){
        try{
            this.arr[index] = Integer.MIN_VALUE;
            System.out.println("Element deleted successfully!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index is not present.!!");
        }
    }
}
```

Here in above code in constructor we are accepting the parameter sizeOfArray and creating an integer array of that size. 
Also, we are adding 10,20,30... values based on index in the array. So constructor is creating an array with values for us.
We have another method 'deleteElementOfAnArray' which accepts the index from where we want the element to be deleted. 
Then based on that index we are accessing the array value and changing it to the default integer minimum value.
If array index is not present then we are printing the string 'Array index is not present.!!'.  

To test this code we are calling above method from Main.java class.

Main.java
```java
package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        System.out.println("Array before deleting any element "+Arrays.toString(sda.arr));

        sda.deleteElementOfAnArray(3);

        System.out.println("Array after deleting 3rd element "+Arrays.toString(sda.arr));
    }
}
```

The output of above code will be.

```markdown
Array before deleting any element [10, 20, 30, 40, 50]
Element deleted successfully!
Array after deleting 3rd element [10, 20, 30, -2147483648, 50]
```

From above output we can see that the value at index 3 i.e. the 4th value is deleted successfully (i.e. modified to integer 
minimum value). The time and space complexity for above code is O(1). As we are not looping or using any additional space.
