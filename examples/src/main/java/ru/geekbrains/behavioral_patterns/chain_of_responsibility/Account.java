package ru.geekbrains.behavioral_patterns.chain_of_responsibility;

public abstract class Account {

    protected Account successor;
    protected float balance;

    public void setNext(Account account) {
        this.successor = account;
    }

    public void pay(float amountToPay) {
        if (this.canPay(amountToPay)) {
            System.out.printf("Paid %s using %s", amountToPay, this.getClass().getName());
            System.out.println();
        } else if (successor != null) {
            System.out.printf("Cannot pay using %s. Proceeding ..", this.getClass().getName());
            System.out.println();
            successor.pay(amountToPay);
        } else {
            throw new RuntimeException("None of the accounts have enough balance");
        }
    }

    public boolean canPay(float amount){
        return balance >= amount;
    }


}
