## Creation of an array.

Creation of an array in java include three steps. 
1. Declaration of an array.
2. Instantiation of an array.
3. Initialization of an array.

(We can combine all these steps in a single one, but that we will see further down in this section.)

Now to understand each step let's have a look at below example.

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr;          // Declaration
        arr = new int[5];   // Instantiation

        arr[0] = 5;         // Initialization (all 4 lines)
        arr[1] = 6;
        arr[2] = 7;
        arr[3] = 8;
        arr[4] = 9;

        System.out.println(Arrays.toString(arr));
    }
}
```

Here at line `int[] arr;` we are declaring the array. At this point only a reference variable will be created in the memory 
which will be associated with the name 'arr'. So variable arr will refer to the memory location/address of reference variable.

![Creating an array - 1(03-Arrays/03.1-Creation of an array/images/creating-array-1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.1-Creation%20of%20an%20array/images/creating-array-1.png)

Now the second step is 'Instantiation', here an actual instance of the array is created. At line `arr = new int[5];`, we 
are instantiating the array of 5 elements. So at this step 5 continuous memory locations are reserved in the memory 
location and default value is assigned to these memory locations (based on the type of array). And in memory address of 
reference variable which was created in first step, the address for first location is stored. Have a look at below diagram.

![Creating an array - 2(03-Arrays/03.1-Creation of an array/images/creating-array-2.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.1-Creation%20of%20an%20array/images/creating-array-2.png)

From above diagram we can see that 5 continuous memory locations are reserved and the default value 0 is assigned to them
(0 because it is an integer array). Also, the first memory location of the 5 consecutive locations i.e. m37 is stored in 
the reference variable, so now arr refers to the reference variable memory m49 which stores the address of first out of 5 
locations which is m37. So when we say array element at index 0 that means array element at starting location (i.e. location 
stored in reference variable) plus 0 so m37+0 which m37 only, so arr[0] is element at memory location 'm37'. Similarly, 
element at array index 1 i.e. arr[1] is m37+1 which is m38 so element at memory location m38. 
Now at this stage if we print the array by using `Arrays.toString()` we will get the default values at all positions.

Now at third step i.e. initialization of the array, Here we are using array index and adding the value one by one. So at 
that specific memory location given value will get stored. (refer below diagram)

![Creating an array - 3(03-Arrays/03.1-Creation of an array/images/creating-array-3.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/03-Arrays/03.1-Creation%20of%20an%20array/images/creating-array-3.png)

Now whenever we try to access the array element using index let's say arr[3] then it will first look at the arr variable 
and get the starting index of array which is m37 then it will add the give index value which is 3 to it, resulting to memory 
address m40. And then fetch the value at the memory location m40 which is 8. 

If we analyse the time complexity for above operation then it will be like below.

Declaration of array i.e. `int[] arr;` is kind of assignment (assigning memory address and creating reference variable), 
so it will have O(1) time complexity.<br>
Instantiation of array i.e. `arr = new int[5];` is simple assignment, so it will also have O(1) time complexity.<br>
After this we are assigning values to each array location which indeed is an assignment only, but if we have N number of array
elements then the assignment operation will also be N times. Hence indirectly this is dependent on size of N, hence the 
time complexity will be O(N).<br>
So overall time complexity for creation of an array using above way is O(N).

But we can combine all the steps in one single step like below.

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
    }
}
```

Here in above example all the steps i.e. declaration, instantiation and initialization are combined into one step.
This step is simple assignment of all the array elements in one go hence no matter how large the array is the code will 
execute only once hence the time complexity for above way of creating an array is O(1).

