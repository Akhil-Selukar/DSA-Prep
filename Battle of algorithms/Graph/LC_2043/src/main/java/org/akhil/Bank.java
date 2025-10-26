package org.akhil;

class Bank {

    long[] accounts;
    int n;
    public Bank(long[] balance) {
        accounts = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > n || account2 > n || accounts[account1-1] < money){
            return false;
        }

        accounts[account1-1] = accounts[account1-1] - money;
        accounts[account2-1] = accounts[account2-1] + money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > n){
            return false;
        }

        accounts[account-1] = accounts[account-1] + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > n || accounts[account-1] < money){
            return false;
        }
        accounts[account-1] = accounts[account-1] - money;
        return true;
    }
}
