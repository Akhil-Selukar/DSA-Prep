### 122 - Best time to buy and sell the stock II

**Question link** - [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

**Topics** - Arrays, Recursion, DP

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here we are given with an array just like in problem [LC-121](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_121/README.md)
The only difference here is we can buy and sell stock multiple times. Which means you can buy a stock today sell tomorrow 
and then again buy tomorrow or day after tomorrow. The thing to notice here is that you can't hold more than 1 stock with you
at any point in time. Hence, if you are buying a stock then to buy stock again you will have to first sell the existing stock.
After all such buy adn sell transactions we need to ensure the maximum profit after the given period of time.

Now consider you are given data of 5 days then there can be many possible combinations like buy on day 1 and sell on day 
two. Then buy on day 3 and sell on day 4, or just buy on day 1 and sell n day 3 and then buy and day 4 and sell on day 5
and so on. To identify the maximum profit we need to check all such possible scenarios and profit we can get from the 
transactions. As we need to check all possible ways we will go with recursion here.

Consider given values are `prices = [7,1,5,3,6,4]`. So to start recursion we can start from index 0 (in stock problems 
almost every time we need to start from 0 index). Now when we are at 0 index we don't have any previous holding so we
will not be able to sell anything but for buying we have open choice to either buy or not buy the stock. Hence we can say 
that in every recursive call we need to inform that are we allowed to buy or not. Hence, along with index we will have to 
carry an indicator to inform do we have any stock with us or not (i.e. holdings). If we have any holding then we are not 
allowed to buy again hence only option left will be to sell. Now for selling we will have again tow choices i.e. either to 
sell on that day or skip that day and sell some other day later. The structure of recursive function or the changing 
parameters here will be index (i.e. the day) and holding (which will have either 0 or 1. And if we have 0 that means we 
can not sell and only option available is to buy, and if holding is 1 that means we can only sell and no option available 
to buy). As seen earlier in case of both buy and sell we have two choices either to buy/sell on that day or wait for some 
other day. Hence the recurrence relation can be formed like below.

1. First thing is based on holding we will decide are we going to sell or buy the stock.

![LC-122 image-1](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_122/src/main/resources/images/LC-122%20image-1.jpg)

Now in case of buy if we choose to buy on that day then the amount or cash that we have we will have to give it, which means 
for us it will be a negative transaction (even `profit = sell - buy` i.e. buy operation is a negative term). Hence we will
subtract the price at that day (i.e. buying price). Also as we have bought the stock today hence tomorrow we will not be 
allowed to buy another stock as we have the holding 1 now. Hence next days recursive call will be called with holding value 
as 1 and as next day's transaction will be of sell hence the money/cash will come to us hence this will be a positive 
transaction. 

![LC-122 image-2](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_122/src/main/resources/images/LC-122%20image-2.jpg)

Another option is we can skip for today and decide to buy tomorrow. In that case the negative (i.e. buy) transaction will 
be 0 and sell transaction will be with holding 0 as we have not bought anything.

![LC-122 image-3](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_122/src/main/resources/images/LC-122%20image-3.jpg)

Now as we want to maximize the profit hence we will take the max of both choices.

![LC-122 image-4](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_122/src/main/resources/images/LC-122%20image-4.jpg)

Similar equations can be written for sell operation as well. If we choose to sell the stock today then we will have the 
sell value as the positive transaction. And if we are selling the stock then teh holding will become 0.

![LC-122 image-5](https://github.com/Akhil-Selukar/DSA-Prep/blob/master/Leetcode%20questions/LC_122/src/main/resources/images/LC-122%20image-5.jpg)

Now the recurrence relations are ready and we need the base case. As the given prices are for n number of days, and we are 
asked to calculate maximum profit that we can get in those days. Hence, no matter what if we hold any holding after the last 
day its value we can't consider in our profit as we cant sell after last day and hence the value will not be added in profit.
Hence as soon as we reach the end of array we can simply return 0. (i.e. no further value of holding/buy/sell)

#### Another Solution
As in the problem it is given that multiple transactions on the same day are allowed provided we are not holding more than 
1 share at any point in time. (i.e. the day I bought a stock I can sell it on the same day - This will be of no use because
price will be same hence profit will be 0. But if I have a stock bought earlier at soe lower price and today I'm getting 
some profit so I can sell it and book the profit and again buy the stock at same day to sell on next day.) Hence using 
this intuition we can simply go ahead and iterate over array and check if current day price is more than previous day's 
price if yes than consider we did bought a stock on previous day and sell it today and add difference in profit. Repeat 
this for all days and we will get the max profit.