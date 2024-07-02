## 04 ArrayList

Arraylist is an implementation of list interface, it is a resizable datastructures in java which can grow and shrink during runtime. 
Arraylist internally uses Array datastructures, but it internally handles resizing based on addition and removal of elements 
during runtime. Arraylist also provides various builtin useful method for data manipulation. In real life consider your 
playlist on spotify as an arraylist. In your playlist you don't have to specify that how many songs you are going to add while
creating playlist, neither spotify allocate specific memory for your playlist beforehand. You can add as many songs as you 
want and when you start removing songs the memory associated with it is released. 

This resizability is the most important and distinguishing feature of Arraylist which separate it from normal array. But 
we must keep in mind that due to its dynamic sizing the operations on arraylist are time-consuming as compared to array.

Another important feature of Arraylist which distinguish it from array is, array is type safe. Means we have to specify the 
type of elements we are going to store in an array while declaring an array and after that we can only store that type of 
element only. But in case of arraylist (arraylists are not type save though we can achieve type safety very easily). It 
is not compulsory to specify the type of arraylist while creating it, and if we don't specify the type then we can store 
any type of element in it. i.e. below is totally valid and will work without any error.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(1);
        list.add("java");
        list.add(true);

        System.out.println(list);
    }
}
```

In above example we have created an arraylist and stored a number 1, then a string 'java' and then boolean value true in 
it. This is totally valid as we have not specified the datatype of arraylist. While if we specify the datatype like below 
then the arraylist will become typesafe.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add(1);
        list.add("java");
        list.add(true);

        System.out.println(list);
    }
}
```

Now here we have specified the datatype as 'String' hence adding 1 amd boolean value 'true' will show you compilation error 
`java: incompatible types: int cannot be converted to java.lang.String`
Above is how we can achieve type safety in java.

We have seen above what exactly arrays are, now let's understand how arrays are stored in the memory. As we know that arrayList
internally uses array data structure and manages the growing and shrinking internally. So initially when
we initialize an arrayList, it creates an initial array of 10 elements in memory. And when we start adding elements to the 
arrayList, it adds those elements in this array of 10 elements, just like normal array. Have a look at below code and the 
explanation.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");

        System.out.println(list);
    }
}
```
Here as soon as the line `ArrayList<String> list = new ArrayList<>();` is executed, a memory location will be assigned for
'list' variable and an array of size 10* will be created. The memory location of starting location of array will be stored in 
the variable 'list'. Have a look at below image.

> <span>*</span> The initial capacity of 10 depends upon the version of java and implementation of arrayList in that version. In java 8
>as soon as we create an arraylist first an array of size 0 will be created (i.e. array declaration) but upon adding the 
>first element to the arraylist, an array of size 10 will be instantiated in memory.

![Arraylist in memory - 1 (04-ArrayList/images/Arraylist in memory - 1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20in%20memory%20-%201.png)

Here we can see that a variable named 'list' is created which is assigned with the memory location 'm02'. Also, an empty 
array of 10 elements is created and the starting location of the array which is 'm35' is stored in 'm02'. So indirectly 
the arraylist 'list' points out to the starting location of array with 10 elements.

Now when we add elements 'Java', 'JavaScript' and 'Python' in the array. They will be sequentially stored in array,
starting from memory locations 'm35'.

![Arraylist in memory - 2(04-ArrayList/images/Arraylist in memory - 2.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20in%20memory%20-%202.png)

Now consider you have added 10 elements to the arraylist and trying to add another element i.e. 11th element. In this case
instead of throwing an exception like array, arraylist creates a new array with size increased by the factor of 0.5 or 1
i.e. (15 in case of 0.5 or 20 in case of 1. This factor depend upon the internal implementation of arraylist in your java 
version). Now after creating new array it copy all the element from previous array to the new array and then add 11th element 
at the end of it. Have a look at below example.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");
        list.add("C");
        list.add("C++");
        list.add("Ruby");
        list.add("GoLang");
        list.add("ReactJS");
        list.add("NodeJS");
        list.add("Numpy");
        list.add("Pandas");

        System.out.println(list);
    }
}
```

![Arraylist in memory - 3(04-ArrayList/images/Arraylist in memory - 3.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20in%20memory%20-%203.png)

Here you can see that there is no space left for element 'Pandas' so what will happen is it will create a new array of size
15 elements (i.e. 10 + 0.5 times 10), then copy all the elements from previous array to the new array and at the end it will 
add 'Pandas'. This growing of array when required is handled internally by arraylist. Have a look at below image.

![Arraylist in memory - 4(04-ArrayList/images/Arraylist in memory - 4.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20in%20memory%20-%204.png)

Now what if we remove an element from middle of the arraylist by using method `.remove()` provided by arraylist. 
In that case all the elements from right of the deleted elements will be shifted 1 place left. Have a look at below code. 

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");
        list.add("C");
        list.add("C++");
        list.add("Ruby");
        list.add("GoLang");
        list.add("ReactJS");
        list.add("NodeJS");
        list.add("Numpy");
        list.add("Pandas");

        list.remove("C++");

        System.out.println(list);
    }
}
```

Here after adding all the 11 elements we are removing 'C++'. So all the elements after C++ will be shifted to left in memory.

![Arraylist in memory - 5(04-ArrayList/images/Arraylist in memory - 5.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20in%20memory%20-%205.png)

Here one thing to note is, even the array now came back to withing its original size, still it will not automatically shrink.
We have to call '.trimToSize()' method. After calling this method the internal operations are taken care off by arrayList.

