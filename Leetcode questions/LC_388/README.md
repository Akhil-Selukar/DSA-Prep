### 388 - Longest absolute file path

**Question link** - [Link](https://leetcode.com/problems/longest-absolute-file-path/description/)

**Topics** - String, Stack

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here the most important point is to visualize the given file structure in tree form where `\t` represent the next level in
the tree and each file or directory is node. Have a loot at below example.

path  = `dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext`<br>
The pictorial representation of above path will be like below.

![LC-388 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_388/src/main/resources/images/LC_388_image-1.jpg)

Now if we just tilt the above structure by 90 degree clockwise we can see it as a tree where each `\t` represent next level
in the tree (i.e. depth) and each file or directory as a node.

![LC-388 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_388/src/main/resources/images/LC_388_image-2.jpg)

Here each `\t` represent the next level\depth in the tree and at each `\t` we will need only single backslash which will contribute 
only 1 to path length. 

Now the question became a bit simpler. We have to traverse each path of the tree till we reach the file (i.e. a name which 
contains `.` in it and calculate the length of the path).

The important point to note here is that while switching from `subdir1` to `subdir2` we need to ensure that we are removing 
the path traversed till `file1.ext`. (perform a dryrun on code for better understanding).

> Important point: <br>
> In java all escape sequences like \t, \n, etc will give length as 1 even though it consists of a slash and a char. 
> Also in string `\tjava` if we try to read charAt(0) we will get `\t` and not just \.
> 
> Which means entire escape sequence is considered as a single character.