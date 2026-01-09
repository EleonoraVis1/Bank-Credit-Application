package com.example.demo;

public class BaseAccount {
    protected String name;
    protected float balance;
    public BaseAccount() {
    }
    public BaseAccount(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    void deposit(double sum) {
        balance += sum;
    }
    boolean check(float sum) {
        if(balance + sum > 1000){
            return false;
        }
        return true;
    }
}