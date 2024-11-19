### StringBuffer class

StringBuffer is a class in Java that represents a mutable sequence of characters. It provides an alternative to the immutable 
String class, allowing us to modify the contents of a string without creating a new object every time.

As we know that String class is immutable, meaning once we create an object of string if we want to change the value of it
then we can't do that, we have to create a new object all together. This is not the case with StringBuffer. StringBuffer 
provides methods like append(), replace(), insert(), replace(), delete(), deleteCharAt(), etc to modify the character sequence 
stored in it.

The same thing can be achieved by using StringBuilder class as well. But there are some important differences between StringBuffer 
and StringBuilder which makes huge difference and selection of proper class very important depending on the nature of application.
Below are the differences between StringBuffer and StringBuilder.

| StringBuffer                                                                                                  | StringBuilder                                                                                                                |
|---------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| StringBuffer is thread safe (synchronized). (Only one thread can access/modify StringBuffer object at a time. | StringBuilder is not thread safe (asynchronized). (Multiple threads can access/modify StringBuilder object at the same time. |
| As it is thread safe and only one thread can access it at a time so it is slow.                               | As multiple threads can access/modify StringBuilder object at a time hence it is fast.                                       |
 | Used in multithreaded environments where we don't want multiple threads modifying same object.                | Used in single-threaded environments where we know that there wont be more than one thread at a time.                        |

> In interview questions or online coding tests always prefer StringBuilder over StringBuffer due to its speed as all those 
> environments are single-threaded.

Some important methods provided by StringBuffer class. (All methods by String class are also supported by StringBuffer).

| Method                                       | Description                                                                                       |
|----------------------------------------------|---------------------------------------------------------------------------------------------------|
| .append()                                    | Used to add text at the end of the existing text.                                                 |
| .length()                                    | Gives us the length of StringBuffer                                                               |
| .capacity()                                  | Returns the total capacity of StringBuffer. (initial capacity is 16)                              |
| .charAt(_index_)                             | Returns the character at specified index.                                                         |
| .delete()                                    | Delete the sequence of characters from StringBuffer                                               |
| .deleteCharAt(_index_)                       | Delete character at the specified index.                                                          |
| .insert(_index_, _String_)                   | Insert given string at specified index (index starts from 0)                                      |
| .reverse()                                   | Reverse the characters in StringBuffer object.                                                    |
| .replace(_startIndex_, _endIndex_, _String_) | Replace the characters from start index (inclusive) till end index (exclusive) with given String. |
| .toString()                                  | Return the String of characters present in StringBuffer object.                                   |

StringBuffer class has 3 constructors present in it.
1. **Constructor without parameter** - `StringBuffer sb = new StringBuffer()` This creates an object of StringBuffer class 
with default capacity of 16.
2. **Constructor with integer value (capacity)** - `StringBuffer sb = new StringBuffer(32)` This creates object of StringBuffer 
class with specified initial capacity.
3. **Constructor with String value** - `StringBuffer sb = new StringBuffer("Hello world")` This creates a StringBuffer object
with given string.

> Checkout the code in Main.java for example.