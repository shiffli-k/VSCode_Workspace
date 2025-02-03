package com.software.design.patterns.decorator;

public class ItalianPizza implements Pizza {

    private double cost = 600.00d;
    private sizes sizeOfPizza = sizes.MEDIUM;
    private String addons = "Basil, Mozzarella";

    public ItalianPizza(Pizza.sizes sizeOfPizza) {
        this.sizeOfPizza = sizeOfPizza;
        switch (sizeOfPizza) {
            case Pizza.sizes.LARGE:
                this.cost+=150.50d;
                break;
            case Pizza.sizes.SMALL:
                this.cost-=230.70d;
                break;
            default:
                break;
        }
    }

    @Override
    public String getDetails() {
        return pizzaInfo();
    }

    @Override
    public void bakePizza() {
        System.out.println("Its being baked! " + pizzaInfo() + " is preparing!");
    }

    private String pizzaInfo() {
        return "Your " + sizeOfPizza.toString().toLowerCase() + " pizza of costs " + cost + "INR" + " w/ toppings: "
                + addons;
    }

}
