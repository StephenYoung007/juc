package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public abstract class Dessert extends Drink {
    private Drink drink;

    public Dessert() {
    }

    public Dessert(String name, String description, int price, Drink drink) {
        super(name, description, price);
        this.drink = drink;
    }

    @Override
    public String print() {
        return this.getDrink().print() + this.getDescription();
    }
}
