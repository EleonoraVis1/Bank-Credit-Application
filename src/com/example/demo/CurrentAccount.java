package com.example.demo;

public class CurrentAccount extends BaseAccount{
    private String tipas="einamoji sąskaita";
    public CurrentAccount(String tipas) {
        this.tipas = tipas;
    }
    public CurrentAccount() {
        super("tekstas");
        super.name="tekstas";
        super.deposit(20);
        this.tipas = "nežinomas";
    }
    @Override
    public boolean check(float sum) {
        return !(balance + sum > 1000);
    }

}