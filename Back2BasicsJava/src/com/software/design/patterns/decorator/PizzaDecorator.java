package com.software.design.patterns.decorator;

public abstract class PizzaDecorator implements Pizza {
    private Pizza thePizza;

    public PizzaDecorator(Pizza pizza) {
        this.thePizza = pizza;
    }

    @Override
    public String getDetails() {
        return this.thePizza.getDetails();
    }

    @Override
    public void bakePizza() {
        this.thePizza.bakePizza();
        return;
    }

}
