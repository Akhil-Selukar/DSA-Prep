package org.akhil;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    // Solution 1 - Using stack
    // O(N)/O(K) - TLE
    // Stack<Integer> main;
    // Stack<Integer> used;

    // public ProductOfNumbers() {
    //     main = new Stack<>();
    //     used = new Stack<>();
    // }

    // public void add(int num) {
    //     main.add(num);
    // }

    // public int getProduct(int k) {
    //     int n = k;
    //     int product = 1;
    //     while(n > 0){
    //         int num = main.pop();
    //         product = product * num;
    //         used.push(num);
    //         n--;
    //     }

    //     while(!used.isEmpty()){
    //         main.push(used.pop());
    //     }
    //     return product;
    // }

    // ------------------------------

    // Solution 1 - Using stack
    // O(N)/O(K)
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        // if the num is zero then the entire product will become zero so start new list.
        if(num == 0){
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(list.get(list.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        // if we dont have enough elements then there must be a zero somewhere in that range making the product zero.
        if(k >= list.size()){
            return 0;
        }

        return list.get(list.size()-1)/list.get(list.size() - k - 1);
    }
}