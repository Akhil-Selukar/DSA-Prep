### Power exponentiation 

Power exponentiation is a technique to calculate a<sup>b</sup> in `log(b)` time complexity.
Here we use simple technique of doubling the base and halving the exponent.
<br> Consider example of 2<sup>8</sup><br>

Here we can rewrite 2<sup>8</sup> as below

2<sup>8</sup> = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2<br>
2<sup>8</sup> = 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>2</sup><br>
2<sup>8</sup> = 4 * 4 * 4 * 4<br>
2<sup>8</sup> = 4<sup>2</sup> * 4<sup>2</sup><br>
2<sup>8</sup> = 4<sup>4</sup><br>

`Here we doubled the base and halved the expponent`

Again we can further do the same thing and write it as.

4<sup>4</sup> = 4 * 4 * 4 * 4<br>
4<sup>4</sup> = 16 * 16<br>
4<sup>4</sup> = 16<sup>2</sup>

`Same thing, we doubled the base and halved the exponent`

Again repeat the same process.

16<sup>2</sup> = 16 * 16<br>
16<sup>2</sup> = 256<br>
16<sup>2</sup> = 256<sup>1</sup><br>

now as our exponent is 1, so if we half it again it will be 0 so we got the answer.<br>
Here if we observe we just have to do 'double base and halve exponent' only 3 time, This is much less than multiplying 2 to itself 8 times.
Hence this approach is efficient.

#### edge case of odd power.
In case of odd power if we divide it by 2 fot (halving it), we will left with 1 as remainder. We have to consider this remainder 1 as well.
i.e. in case of 2<sup>9</sup>

2<sup>9</sup> = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2<br>
2<sup>9</sup> = 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>1</sup><br>
2<sup>9</sup> = 4<sup>4</sup> * 2<sup>1</sup><br>
2<sup>9</sup> = `answer or norman algorithm` * `base`

Hence wherever there is a odd power during halving process we need to make sure that we multiple the ans by base.

This can arise in between as well like for 2<sup>6</sup><br>

during first iteration it is fine<br>
2<sup>6</sup> = 4<sup>3</sup><br>
during second iteration (here we have odd exponent so here we need to multiple answer by 4).<br>
2<sup>6</sup> = 4<sup>3</sup> = 16<sup>1</sup> * 4<sup>1</sup><br>

