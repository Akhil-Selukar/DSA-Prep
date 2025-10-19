### 1625 - Lexicographically Smallest String After Applying Operations

**Question link** - [Link](https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/)

**Topics** - String, Graph (This is important to identify why it is graph problem)

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>

We are given with a state and we can perform any given operations infinite number of times. So if we check both the operations
1. **Rotation** - After some rotation we will for sure get the same number back (try with paper and pen) (this will always be the 
case in such problems). So in short for rotation operation the states are finite.

2. **Addition** - If we add given number at odd places (or even places for that matter). As it is given that after 9 we are 
rotating the number and we are not going to 10,11,12 and so on so after some additions this will also repeat itself (i.e. we will
get the same number back). 

So the conclusion from here is, even though it seems like infinite combinations are possible here but actually the combinations are 
finite. Now we have choice of performing any operation at every state so it might feel like a 0-1 knapsack type or recursion. But 
actually we have to evaluate each state and both operations so its just like from one state we eventually need to visit next both 
possible states and from there again we need to visit their possible states and so on. So it is kind of visiting nodes of graph
where each state is a node in the graph and to reach that stape we can use the operations allowed. 

> The main difference in such problems and in 0-1 knapsack problems are in this kind of problems we dont have any base case.
I mean we need to identify lexicographically smallest possible string. But how will you decide from where we should not go
any further in the recursion we dont have any base case. If we saw any previously seen value then we can say that this path is 
already checked, this is what we do in graph traversals using visited array (set in this case).  
