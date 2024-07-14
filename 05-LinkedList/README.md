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
>as soon as we create an arraylist first an array of size 1 will be created, but upon adding the first element to the arraylist, 
>an array of size 10 will be instantiated in memory.

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

Now as we know how arraylist works and how it is stored in memory, let's see some operations on arraylist and there time 
and space complexity.

### 1. Creation of an arraylist.

We can create arraylist of two type, (typesafe arraylist and generic arraylist) in case of typesafe arraylist we can store 
element of only specific type while in case of generic arraylist we can store element of any datatype.
The syntax of creating and arraylist is as below.

```markdown
// typesafe arraylist
ArrayList<String> list = new ArrayList<>();

// generic arraylist
ArrayList list = new ArrayList();
```

in both the cases, as we have already seen above it internally creates an array of default size (in some java versions it is 10
while in some it is 1). In case of default size 10 it will create an element of size 10 and upon adding elements to the arrraylist
it will add the elements in that array. While in case of default size of 1 it will create an array and as soon as we add 1st
element it increases the size of the array to 10.

Apart from default size we can also specify the initial size by passing the number while creating an arraylist

```markdown
// typesafe arraylist
ArrayList<String> list = new ArrayList<>(18);

// generic arraylist
ArrayList list = new ArrayList(18);
```

Both the above syntax will create an internal array of initial size 18. 

So the overall code of creation of an arraylist is like below

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println(list);
    }
}
```

Above code will print `[]` i.e. an empty arraylist.

If we evaluate the code for time and space complexity, as we are not iterating over anything neither our code depend upon 
any of the input so the time complexity will be 'O(1)'. But the space complexity will depend upon the java version. If the 
java version has default arraylist size as 1. Then the space complexity for creation of an arraylist will be O(1), But in 
general we consider that we provide the size parameter while creating an arraylist so the size of initial arraylist will be
the initial size we passed hence the space complexity will be considered as 'O(N)', where N is the initial size of arraylist.


### 2. Insertion in arraylist

We can add element in an arraylist by using `.add()` method. This method has two variations. One is with single argument 
which will add the element at the end of the arraylist and second is with two arguments which will add the element (i.e. 
second argument) at the given index (i.e. first argument). Now let's see both the variations one by one using actual code

#### a. add() method with single parameter. 
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        
        System.out.println(list);
    }
}
```

Here in above code we can see that we are using only 1 parameter with add method so when above code is executed, it will 
first create an empty arraylist, and then it will add "java" first at index 0, then it will add "C" at index 1, and then 
"C++" at index 2. So addition of element is at the end of the internal array which is being used by arraylist. This is very
simple and will definitely have O(1) time and space complexity (as the array of default size is already created, and we are 
not creating any additional array).

But what if we have added 10 element and again trying to add 11th element. In this case the things will be different. First 
it will create a new array of increased size, then it will copy all the elements and then add 11th element at the end. This
for sure will not be the O(1) time complexity as a lot of internal work is being done, also we are increasing the space as well
So in this case time and space complexity will be different from O(1). So in such scenarios the time and space complexity is 
said to be **Amortized O(1)***. 

> <span>*</span> Amortized time/space complexity is the way to express the time and space complexity of an algorithm when 
> the algorithm has a very bad complexity once in a while for specific conditions, and has better time complexity otherwise.

#### b. add() method with two parameters.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add(1, "Python");
        
        System.out.println(list);
    }
}
```

In above example first we are creating an arraylist and adding values "Java", "C" and "C++" normally.
These values will be added at index 0, 1 and 2 respectively (of underlying array). Now when we add "Python" using `list.add(1, "Python");`
it will add "Python" at index 1. But index 1 is already occupied by "C". So in this case before adding the new element 
it will first shift all the elements from "C" 1 place right and make the index 1 empty. Then it will add the value "Python" 
at index 1. Have a look at below image for better understanding.

![Arraylist insertion-1 (04-ArrayList/images/Arraylist inssertion-1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20inssertion-1.png)

Now when we try to add new element in between. It shifts all the element after that index one place right and make room for 
new element.

![Arraylist insertion-2 (04-ArrayList/images/Arraylist inssertion-2.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20inssertion-2.png)
![Arraylist insertion-3 (04-ArrayList/images/Arraylist inssertion-3.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20inssertion-3.png)

So if in the worst scenario we already have N elements in arraylist, and we want to add new element at the star i.e. index 0.
In this scenario first all N elements will be shifted one place right then new element addition will be performed. So the
Time complexity will be O(N). And if we want to check the space complexity then in case of arraylist which is having element 
less than it's capacity no extra space will be required so space complexity will be O(1), but as soon as it reaches to its
capacity, additional capacity is added, and the space complexity will be definitely worst than O(1). So space complexity for
insertion in arraylist using .add(index, value) method is amortized O(1).

### 3. Accessing element of arraylist

As we have seen that the Arraylist internally uses array data structure to store elements hence similar to array we can use
index to access elements from an arraylist. The only difference is the syntax of accessing element based on index from arraylist
is `list.get(index)` i.e. we use get method and pass index in the get method instead of directly using [] and passing index in 
it. Have a look at below example.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        
        System.out.println(list.get(1));
    }
}
```

In above example we are accessing the element at index 1, so it will give us 'C' as output.

Here the time and space complexity for accessing element from an arraylist is O(1).

### 4. Traversal of an arraylist
Traversal means visiting each element of an arraylist. We can do this by using below 3 ways.
<ul>
<li>Using for loop</li>
<li>Using foreach loop</li>
<li>Using iterator</li>
</ul>

#### a. Using for loop.
Iterating over an arraylist using for loop is just like iterating over an array we can run the for loop for size of arraylist minus 1
times and access the elements based on index like below.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
```

The output of this code will be.
```markdown
Java
C
C++
Python
```

Here as the execution of for loop is dependent on the size of arraylist hence the time complexity for this code will be O(N)
while as we are not using any extra data structure hence the space complexity will be O(1).


#### b. Using for each loop

For each loop is very much similar to that of for loop, the difference is instead of using the counter and getting the element 
based on index we are directly looping over the elements (or we can say arraylist).

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        for(String language:list){
            System.out.println(language);
        }
    }
}
```

Here as well the output will be same as the of previous. As the iteration of foreach loop depends on the number of elements
present in the arraylist hence the time complexity for this code as well is O(N) while the space complexity is O(1).

#### c. Using iterator
An iterator is an interface in java which provides a way to iterate over collections like arraylist. We can use methods like 
hasNext() and next() to iterate over an arraylist like below.

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```

Above code will also generate the same output. Here as well the while loop will execute N number of time, where N is the 
number of elements present in arraylist. Hence, the time complexity of this approach as well is O(N) while the space 
complexity is O(1). 


### 5. Search for an element in arraylist
For searching any given element as well we have to loop over the arraylist and compare each element with the given element. 
For this same purpose we already have an inbuilt method of arraylist which is `indexOf()`, this method returns the index of 
first occurrence of given element. Below are the examples of both the approaches.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        for(String language:list){
            if(language.equals("C++")){
                System.out.println("C++ is present in arraylist.");
                break;
            }
        }
    }
}
```

Here we are looping over the elements of given arraylist and checking each element against C++. If the element is C++ then 
we are printing that C++ is present in arraylist and exiting the loop using break. Here in worst case it might be possible 
that the element is not at all present in given array, in that case we will be looping over the entire arraylist. Hence the
time complexity for this is O(N) while space complexity is O(1).

The another approach is with indexOf() method.
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        int index = list.indexOf("C++");
        System.out.println("C++ found at index "+index);
    }
}
```

Here in above code indexOf() method returns the index of first occurrence of 'C++'. And if 'C++' is not present in given 
arraylist then it will return -1 as the index. Here as well the time and space complexity will be O(N) and O(1) respectively.

### 6. Deleting an element from arraylist.

Deleting any element from an arraylist can be done by using `remove()` method. We can pass either object or actual element 
which we want to delete from the arraylist. Here the important thing to note that, whenever we delete any element form arraylist
all the element to the right of deleted element are shifted one index left. Have a look at below diagram.

![Deleting element in arraylist - 1(04-ArrayList/images/Arraylist deletion-1.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20deletion-1.png)

Here in above image we have an array with some name of programming languages stored in it. We want to delete the name 'C'
So the 'C' at index 2 will be removed from the arraylist as shown in below image.

![Deleting element in arraylist - 2(04-ArrayList/images/Arraylist deletion-2.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20deletion-2.png)

Now as the element at index 2 is removed so, instead of keeping that place empty all the elements right to the deleted 
elements are shifted to 1 place left.

![Deleting element in arraylist - 3(04-ArrayList/images/Arraylist deletion-3.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20deletion-3.png)

In above image we can see that the at index 2 we have 'C++' now which was there at index 3 earlier.

Let's have a look at the actual code for this.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("Python");
        
        list.remove("C");
        
        System.out.println(list);
    }
}
```

the output of above code will be 
```markdown
["Java", "C++", "Python"]
```

Here as shifting of elements involved, and it might happen that we have to delete element at index 0, in that case all the 
elements will be shifted to left. So the time complexity for this is considered as O(N) and space complexity is considered 
as O(1).

Overall the time and space complexities for different operations on arraylist are as below.

![Time and space complexities for different operations(04-ArrayList/images/Arraylist time and space complixities.png)](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/04-ArrayList/images/Arraylist%20time%20and%20space%20complixities.png)