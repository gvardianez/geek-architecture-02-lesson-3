package ru.geekbrains.behavioral_patterns.chain_of_responsibility;

public class Main {

    public static void main(String[] args) {
        Account bank = new Bank(100);
        Account bitCoin = new BitCoin(200);
        Account payPal = new PayPal(300);

        bank.setNext(bitCoin);
        bitCoin.setNext(payPal);

        bank.pay(259);

    }

}
