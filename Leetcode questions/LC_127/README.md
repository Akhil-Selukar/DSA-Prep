### 127 - Word ladder

**Question link** - [Link](https://leetcode.com/problems/word-ladder/description/)

**Topics** - BFS(Graph), 

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with a word and we have to change 1 letter at a time from that word to reach to the target word. The condition
is after changing 1 letter the new word we are getting that must be present in wordList given. So While changing the letters 
of starting word we have to make sure to consider only those words which are present in wordList.<br>
Here let's start with simple bruteforce approach. Consider the given problem is below.

![LC-127 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-1.jpg)

Now simple thing we can do is start from startWord i.e. `hit` and keep on changing first letter starting from 'a' to 'z'.
After changing the letter we can check of the resultant word is present in given wordlist or not if yes then we can take 
that word and if no then we can skip it.

![LC-127 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-2.jpg)

None of the resulting word is present in given wordList hence we will start changing second letter i.e. i.

![LC-127 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-3.jpg)

Here we can get `hot` which is present in given wordlist hence we can take it. After that check by changing third letter 
That will give us 'hia', 'hib', 'hic'....'hiz' none of which is present in word list so the only possible way we can proceed
from startWord to next step is `hot`. 

Now repeat the same process again for `hot`, starting with first letter.

![LC-127 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-4.jpg)

Here, we can get two acceptable words those are `dot` and `lot`. Now if we try changing second letter. We will get `hot` 
again as we will start from 'hat', 'hbt', ... 'hot'...'hzt', but as 'hot' was already considered we cant go again to 'hot'
This will create a cycle (i.e. from hot to again hot). We need shortest sequence so we should not consider any cycle.

![LC-127 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-5.jpg)

Now if we change third letter then the words which we will get are 'hoa', 'hob', ... 'hoz', none of which is present in 
wordlist hence we will not consider this.<br>
So after second iteration we can get 2 words, those are `dot` and `lot`.

![LC-127 image-6](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-6.jpg)

From here we will again repeat same steps for above two words. (iteration 3).
First lets take word `dot`, if we change first letter we will get 'aot', 'bot', 'cot',....'zot'. None of which are present 
in given word list. So we can switch to second word, here we can get 'dat', 'dbt', 'dct',...'zot', none of which we can consider 
so we can skip this as well. Now while changing third letter we will get below sequence.

![LC-127 image-7](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-7.jpg)

Here we can consider `dog`. Now same process if we apply for `lot` we can get `log`

![LC-127 image-8](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-8.jpg)

Now again we apply same process for both `dog` and `log` we can get target word `cog`

![LC-127 image-9](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-9.jpg)

So we can say we will need minimum 5 transformations to get to the target word. so the answer is 5.

Now if we observe carefully this is a kind of graph like one shown in below image.

![LC-127 image-10](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_127/src/main/resources/images/LC-127%20image-10.jpg)

This is a huge graph where all invalid nodes are highlighted as red and valid nodes are highlighted as green.

Every time we change any letter successfully we go to next level i.e. level by level traversal. Hence this is a graph where 
we need level wise i.e. BFS traversal. 

Now for further optimization we know that for BFS we need a queue and a visited array so that we will not visit already 
visited node again. Here as we don't have numeric node so, we can create a set out of given wordlist and as and when a word is 
visited we can remove that word from set. (set also takes less time to for searching as we will need to search every 
word formed by replacing a letter at every place so there will be many search operations involved and in set we can search in
constant time complexity.)