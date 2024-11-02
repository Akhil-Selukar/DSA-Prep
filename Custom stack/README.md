### Stack datatype

Stack datatype is a datatype in java which follows Last In First Out (LIFO) principle. This means that the element which 
is inserted in the stack at the end will be removed from the stack first. We can not remove element from middle in the stack.

To relate stack with real world we can imagine stack as a pile of books. Now if you want to add another book to the pile 
you can put the new book on top of the pile (it is not good to lift entire pile and add the book at the bottom, what if the 
pile is of 100 books, it is impossible to lift this much books without messing up the entire structure.) So 
insertion is possible at the top of the pile only. Now consider the scenario where you want a book from the same pile. 
You can simply pick the book which is on top (but it is impossible to select specific book from top or from bottom and get 
that one). So we can take out the book from top only. Which means the book which was last added/inserted that will be 
first removed from the stack.

Internally stack is a class which extends vector class. Stack allows five operations which allow vector to be treated as 
stack (push, pop, peek, empty, search). At it's core the elements are stored as array only.

![Stack in real world]()