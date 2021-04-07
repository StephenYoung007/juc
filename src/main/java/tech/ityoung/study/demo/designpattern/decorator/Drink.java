package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public abstract class Drink {
    private String name;
    private String description;
    private int price;

    public Drink() {
    }

    public Drink(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public abstract int cost();

    public abstract String print();
}
