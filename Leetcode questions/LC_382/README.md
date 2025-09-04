### 382 - Linked List Random Node

**Question link** - [Link](https://leetcode.com/problems/linked-list-random-node/description/)

**Topics** - LinkedList, Maths, Reservoir sampling

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -

#### Simplest explanation of reservoir sampling
Imagine you have a giant jar full of marbles, but you can only see one marble at a time. This jar is so huge you can't 
possibly count all the marbles or even fit them all in your hands. Now, your friend asks you to pick just one marble at 
random from the jar. How do you do that fairly, without knowing the total number of marbles? This is the exact problem 
that Reservoir Sampling solves.

**The Basic Idea**<br>
It's a clever way to pick a random sample of items from a huge list (or stream) of data, where you don't know the total size of the list beforehand.
Let's stick with the marbles analogy. You want to pick just one marble (k=1), so you'll need one small container (your "reservoir").

**Step 1:** Get the First Marble.

Take the very first marble from the giant jar. It's the only one you've seen, so it has a 100% chance of being in your container. Put it in.

**Step 2:** Get the Second Marble.

Now take the second marble from the jar. Should you swap it with the one in your container?
You have two marbles you've seen so far. Each one should have a 1/2 chance of being the final choice.

**Step 3:** Get the Third Marble.

Now you've seen three marbles. Each one should have a 1/3 chance of being the final choice.
You pick up the third marble. To make it fair, you imagine a die with three sides. If it lands on your first marble's side, 
you keep your current one. If it lands on the new marble's side, you swap. You essentially give the new marble a 1/3 chance of being picked.

You can extend this pattern to any marble you find.
When you see the Nth marble, you give it a 1/N chance of replacing the marble currently in your container.
This simple rule ensures that no matter how many marbles there are in the jar, every single one has an equal chance of being the one you finally choose.

For video explanation check [this video](https://www.youtube.com/watch?v=Rl7dOXde_2s)