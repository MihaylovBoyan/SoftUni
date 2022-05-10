package com.company.AbstractMethod;

public abstract class FarmProduct {

    private double price;

    public double getPrice() {
        return price;
    }

    public FarmProduct setPrice(double price) {
        this.price = price;
        return this;
    }

    public abstract void prepare();
}
