### Find 'a' raised to power 'b'

You are given two numbers 'a' and 'b', you have to write a function which will find and return a<sup>b</sup>.

**Intuition** -<br>
Here the simple way can be to run a loop 'b' times and multiple 'a' with answer in every iteration.<br>
But the time complexity for this approach will be O(b). 

While using bitwise operator we can solve the same problem in O(log(b)) time complexity.<br>
lets consider a = 2 and b = 5, so we want to calculate 2<sup>5</sup>.<br>
We can write 2<sup>5</sup> as 2<sup>4+1</sup><br>
Which will be nothing but 2<sup>4</sup> x 2<sup>1</sup><br>
Now binary representation of 5 is `101` which is nothing but 2<sup>2</sup>+0+2<sup>0</sup> which is 4+1<br>
Hence we can represent the exponent as binary and consider the position value of each bit. <br>
Also if we consider 2 as base. Then it will be.<br>
2<sup>101</sup><br>
Now as the place value of 0 bit is not considered in binary system so it will be<br>
2<sup>4</sup> * 2<sup>1</sup><br>
In `101` the left most 1 has place value of 1 there we want our base as it is i.e. 2.<br>
Then 0 we want to skip and the rightmost 1 has place value of 4 where we want 2<sup>4</sup> which means base multiplied by itself 
three more times. (i.e. total four 2's multiplied with each other).<br>
Here we can observe that left most 1 is at first place so we have only base. then rightmost base is at third place so we have 
base multiplied by itself 3 more times. So we can simply use that and check binary value of exponent and if it is 1 then we 
will consider the base value at that time and multiply it in answer and if it is zero then skip that base value.

By this way the loop will run only 3 time, which is nothing but bits in binary representation of 'b' hence the time complexity for this
approach will be O(lob(b)).