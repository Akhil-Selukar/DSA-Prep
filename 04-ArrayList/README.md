## 04 ArrayList

Arraylist is a resizable datastructures in java which can grow and shrink during runtime. Arraylist internally uses Array
datastructures, but it internally handles resizing based on addition and removal of elements during runtime. Arraylist also
provides various builtin useful method for data manipulation. In real life consider your playlist on spotify as an arraylist.
In your playlist you don't have to specify that how many songs you are going to add while creating playlist,
neither spotify allocate specific memory for your playlist beforehand. You can add as many songs as you want and when you 
start removing songs the memory associated with it is released. 

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



