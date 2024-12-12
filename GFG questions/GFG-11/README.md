### Alien dictionary

**Question link** - [Link](https://www.geeksforgeeks.org/problems/alien-dictionary/1)

**Topics** - Graph, Topological sort

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

Here the intuition is simple, we know or even in given testcases it is clear that in dict array 'baa' is before 'abdcd', 
that means in alien language 'b' must come before 'a' then only word starting with 'b' is arranged before word starting with 'a'
in the dictionary. Hence if we try to arrange it in a graphical form we can say that 'b' is before 'a' and hence an edge 
is starting from 'b' and ending at 'a' 

![GFG-11 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-11/src/main/resources/images/GFG-11%20image-1.jpg)

Now next if we compare 'abcd' with 'abca' then 'abcd' comes first and then 'abca'. In these two word 'abc' is common hence 
the deciding factor is letter 'd' and 'a'. As 'abcd' is first hence it is clear that in alien language 'd' comes before 'a'.
Which means the edge between 'a' and 'd' will start from 'd' and will end at 'a'.

![GFG-11 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-11/src/main/resources/images/GFG-11%20image-2.jpg)

Now next comparison is between 'abca' and 'cab'. Here as 'abcd' is before 'cab' and letter deciding this is 'a' and 'c'
as 'a' is before 'c', hence the node joining 'a' and 'c' will start from 'a' and will be till 'c'.

![GFG-11 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-11/src/main/resources/images/GFG-11%20image-3.jpg)

Now last word remaining is 'cad' which is after 'cab'. Here deciding letters are 'b' and 'd', and as 'cab' is before 'cad'
hence we can conclude that in alien language 'b' comes before 'd'. So the edge between 'b' and 'd' will start from 'b' and 
will end at 'd'.

![GFG-11 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-11/src/main/resources/images/GFG-11%20image-4.jpg)

Here, as k i.e. number of letters in alien language are given as 4 i.e. first 4 letters in English language a,b,c,d and all 
these 4 are used in the dict so we could create the graph out of them. But what if the value of k is 5 then no information about
'e' is given in dict. In that case we can simply consider 'e' as an orphan node and it can be present either at the start or
at the end. 

![GFG-11 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/GFG%20questions/GFG-11/src/main/resources/images/GFG-11%20image-5.jpg)

Now we have a clear graph present, and we have to ensure the order such that all the nodes are arranged in proper order as
per the graph (i.e. nothing but the topological sort order).
So, just apply topological sorting and if topological sorting is not possible then it is not a valid scenario and we can 
return false, else it will be true (i.e. valid sort is present)