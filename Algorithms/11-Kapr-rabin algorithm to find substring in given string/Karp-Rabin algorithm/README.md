### Karp-Rabin algorithm (Substring search pattern)

Karp-Rabin is an algorithm which uses hash value to check if a string is present as substring in some other string.<br>
For example consider a given string s1 "HelloAllHowAreYouDoing" and you want to check if the string s2 "How" is present in it 
or not. The Karp-Robin algorithm solve this problem in linear time complexity.

The algorithm checks the hash value of string s2 in the second string s2 from 0th index to 's1.length-1' index. If the 
hash value is not matching then it moves ahead and calculate the hash value by removing 0th index and adding s1.length index
element. This is called rolling hash, it takes constant time complexity to calculate the rolling hash.<br>
Now once the has value matches, it checks if the strings are equal or not because two string might have same hash value 
(after hashing).

Here our hash functions (calculateHash and updateHash) are working like below.

![Karp-rabin image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/HashMap/images/Karp-rabin%20image-1.jpg)